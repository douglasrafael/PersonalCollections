package br.edu.uepb.personalcollections.gerenciador;

import br.edu.uepb.personalcollections.dao.AmigoDAO;
import br.edu.uepb.personalcollections.dao.EmprestimoDAO;
import br.edu.uepb.personalcollections.dao.GameDAO;
import br.edu.uepb.personalcollections.dao.HqDAO;
import br.edu.uepb.personalcollections.dao.MidiaDAO;
import br.edu.uepb.personalcollections.dao.TabuleiroDAO;
import br.edu.uepb.personalcollections.dao.UsuarioDAO;
import br.edu.uepb.personalcollections.enums.TipoItem;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import br.edu.uepb.personalcollections.Amigo;
import br.edu.uepb.personalcollections.DLC;
import br.edu.uepb.personalcollections.Emprestimo;
import br.edu.uepb.personalcollections.Game;
import br.edu.uepb.personalcollections.HQ;
import br.edu.uepb.personalcollections.Item;
import br.edu.uepb.personalcollections.ListaDeDesejo;
import br.edu.uepb.personalcollections.Midia;
import br.edu.uepb.personalcollections.Pessoa;
import br.edu.uepb.personalcollections.Serie;
import br.edu.uepb.personalcollections.Tabuleiro;
import br.edu.uepb.personalcollections.Usuario;
import br.edu.uepb.personalcollections.dao.ListaDeDesejoDAO;
import br.edu.uepb.personalcollections.dao.SerieDAO;
import br.edu.uepb.personalcollections.enums.FiltroItem;
import br.edu.uepb.personalcollections.util.MyData;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe gerenciador
 *
 * @author Douglas Rafael
 */
public class Gerenciador {

    private UsuarioDAO usuario;
    private AmigoDAO amigo;
    private HqDAO hq;
    private MidiaDAO midia;
    private GameDAO game;
    private TabuleiroDAO tabuleiro;
    private EmprestimoDAO emprestimo;
    private SerieDAO serie;
    private ListaDeDesejoDAO whishlist;

    private static List<Item> listaDeItens = new LinkedList<>();
    private List<Amigo> listaDeAmigos = new LinkedList<>();
    private List<Emprestimo> listaDeEmprestimos = new LinkedList<>();
    private List<Serie> listaDeSeries = new LinkedList<>();
    private List<ListaDeDesejo> listaDeDesejos = new LinkedList<>();

    /**
     * Método construtor, cria as instâncias dos DAOs.
     */
    public Gerenciador() {
        usuario = new UsuarioDAO();
        amigo = new AmigoDAO();
        hq = new HqDAO();
        midia = new MidiaDAO();
        game = new GameDAO();
        tabuleiro = new TabuleiroDAO();
        emprestimo = new EmprestimoDAO();
        serie = new SerieDAO();
        whishlist = new ListaDeDesejoDAO();
    }

    /**
     * Recupera uma lista completa de todos os itens. Caso não tenha nenhum
     * item, a lista é retornada vazia.
     *
     * @return A lista com todos os items
     * @throws PersonalCollectionsException
     */
    public List<Item> listarItens() throws PersonalCollectionsException {
        listaDeItens.clear();
        if (!listarHQs().isEmpty()) {
            listaDeItens.addAll(listarHQs());
        }
        if (!listarMidias().isEmpty()) {
            listaDeItens.addAll(listarMidias());
        }
        if (!listarGames().isEmpty()) {
            listaDeItens.addAll(listarGames());
        }
        if (listartabuleiros() != null && !listartabuleiros().isEmpty()) {
            listaDeItens.addAll(listartabuleiros());
        }

        return listaDeItens;
    }

    /**
     * Retorna lista com itens disponível para empréstimos.
     *
     * @return Lista de Itens
     * @throws PersonalCollectionsException
     */
    public List<Item> listarItensDisponivelEmprestimo() throws PersonalCollectionsException {
        List<Item> listaDeItensDisponivel = new LinkedList<>();
        // garante o listar emprestimo e itens
        listarEmprestimos();
        listarItens();

        for (Item item : listaDeItens) {
            boolean naoEmprestado = false;
            for (Emprestimo e : listaDeEmprestimos) {
                /**
                 * verifica se tem pelo menos um emprestimo ativo se sim nao
                 * estará disponivel para novos emprestimos
                 */
                if (e.getItem().equals(item) && !e.isFinalizado()) {
                    naoEmprestado = true;
                    break;
                }
                // Se encontrou um emprestimo ativo, 
                // nao precisa procurar mais. o item nao devera ser adicionado na lista de disponiveis
                if (naoEmprestado) {
                    break;
                }
            }
            // Se o item nao estar com nenhum emprestimo ativo, está disponivel
            if (!naoEmprestado) {
                listaDeItensDisponivel.add(item);
            }
        }
        return listaDeItensDisponivel;
    }

    /**
     * Recupera lista de HQs.
     *
     * @return Lista de HQs
     * @throws PersonalCollectionsException
     */
    public List<HQ> listarHQs() throws PersonalCollectionsException {
        return hq.listar();
    }

    /**
     * Recupera lista de mídias (CD/DVD/Blu Ray...).
     *
     * @return Lista de mídias
     * @throws PersonalCollectionsException
     */
    public List<Midia> listarMidias() throws PersonalCollectionsException {
        return midia.listar();
    }

    /**
     * Recupera lista de jogos de videogame.
     *
     * @return Lista de jogos de videogame
     * @throws PersonalCollectionsException
     */
    public List<Game> listarGames() throws PersonalCollectionsException {
        return game.listar();
    }

    /**
     * Recupera lista de jogos de tabuleiro.
     *
     * @return Lista de jogos de tabuleiro
     * @throws PersonalCollectionsException
     */
    public List<Tabuleiro> listartabuleiros() throws PersonalCollectionsException {
        return tabuleiro.listar();
    }

    /**
     * Insere um item fazendo o mapeamento de acordo com a instancia do objeto e
     * insere na lista correspondente.
     *
     * @param o Objeto do tipo item a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirItem(Object o) throws PersonalCollectionsException {
        if (o instanceof Tabuleiro) {
            Tabuleiro t = (Tabuleiro) o;
            tabuleiro.save(t);
        } else if (o instanceof Game) {
            Game g = (Game) o;
            game.save(g);
        } else if (o instanceof Midia) {
            Midia m = (Midia) o;
            midia.save(m);
        } else if (o instanceof HQ) {
            HQ h = (HQ) o;
            hq.save(h);
        }
    }

    /**
     * Remove um item fazendo o mapeamento de acordo com a instancia do objeto.
     * OS Empréstimos relacionados ao item também são removidos.
     *
     * @param Item Objeto do tipo item a ser removido
     * @throws PersonalCollectionsException
     */
    public void removerItem(Item o) throws PersonalCollectionsException {
        if (o instanceof Tabuleiro) {
            Tabuleiro t = (Tabuleiro) o;
            removerTabuleiro(t.getId());
        } else if (o instanceof Game) {
            Game g = (Game) o;
            removerGame(g.getId());
        } else if (o instanceof Midia) {
            Midia m = (Midia) o;
            removerMidia(m.getId());
        } else if (o instanceof HQ) {
            HQ h = (HQ) o;
            removerHQ(h.getId());
        }
    }

    /**
     * Atualiza um item fazendo o mapeamento de acordo com a instancia do
     * objeto, atualizando o item relacionado ao tipo de item.
     *
     * @param o Objeto do tipo item a ser inserido
     * @throws PersonalCollectionsException
     */
    public void atualizarItem(Object o) throws PersonalCollectionsException {
        if (o instanceof Tabuleiro) {
            Tabuleiro t = (Tabuleiro) o;
            tabuleiro.atualizar(t);
        } else if (o instanceof Game) {
            Game g = (Game) o;
            game.atualizar(g);
        } else if (o instanceof Midia) {
            Midia m = (Midia) o;
            midia.atualizar(m);
        } else if (o instanceof HQ) {
            HQ h = (HQ) o;
            hq.atualizar(h);
        }
    }

    /**
     * Pesquisa por item de acordo com o id e o tipo
     *
     * @param id
     * @param tipo
     * @return
     * @throws PersonalCollectionsException
     */
    public Item pesquisarItem(int id, TipoItem tipo) throws PersonalCollectionsException {
        Object o = null;
        if (tipo == TipoItem.HQ) {
            o = hq.pesquisar(id);
        } else if (tipo == TipoItem.MIDIA) {
            o = midia.pesquisar(id);
        } else if (tipo == TipoItem.JOGOVIDEOGAME) {
            o = game.pesquisar(id);
        } else if (tipo == TipoItem.JOGOTABULEIRO) {
            o = tabuleiro.pesquisar(id);
        }

        // Verifica se o objeto é do tipo item
        if (o instanceof Item) {
            return (Item) o;
        } else {
            return null;
        }
    }

    /**
     * Pesquisa por item de acordo com o id
     *
     * @param id
     * @return
     * @throws PersonalCollectionsException
     */
    public Item pesquisarItem(int id) throws PersonalCollectionsException {
        Item item = null;
        if (listaDeItens.isEmpty()) {
            this.listarItens();
        } else {
            for (Item i : listaDeItens) {
                if (i.getId() == id) {
                    item = i;
                    break;
                }
            }
        }
        return item;
    }

    /**
     * Busca por itens utilizando o filtro. Simula um like %termo% do SQL.
     * Maiuscula e minuscula são ignorados.
     *
     * @param filtro
     * @param termo
     * @return
     */
    public List<Item> pesquisarItem(FiltroItem filtro, String termo) {
        List<Item> lista_search = new LinkedList<>();

        /**
         * String para simular o like
         */
        String regex = "(?i).*" + termo + ".*";

        for (Item item : listaDeItens) {

            if (filtro.equals(FiltroItem.TITULO)) { // Busca pelo título do item (Todos items são considerados)
                if (item.getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.ESTADO)) { // Busca pelo estado do item (Todos items são considerados)
                if (item.getEstado().getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.HQTITULO) && item.getTipo().equals(TipoItem.HQ)) { // Busca por título de HQ
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.HQESTADO) && item.getTipo().equals(TipoItem.HQ)) {  // Busca pelo estado da HQ
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getEstado().getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.HQEDITORA) && item.getTipo().equals(TipoItem.HQ)) {  // Busca pela editora da HQ
                HQ h = (HQ) item;
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (h.getEditora().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.HQUNIVERSO) && item.getTipo().equals(TipoItem.HQ)) {  // Busca pelo universo da HQ
                HQ h = (HQ) item;
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (h.getUniverso().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.MIDIATITULO) && item.getTipo().equals(TipoItem.MIDIA)) { // Busca pelo titulo da midia
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.MIDIAESTADO) && item.getTipo().equals(TipoItem.MIDIA)) { // Busca pelo estado da mídia
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getEstado().getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.GAMETITULO) && item.getTipo().equals(TipoItem.JOGOVIDEOGAME)) { // Busca pelo titulo do jogo de videogame
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.GAMEESTADO) && item.getTipo().equals(TipoItem.JOGOVIDEOGAME)) { // Busca pelo estado do jogo de videogame
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getEstado().getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.GAMEDLC) && item.getTipo().equals(TipoItem.JOGOVIDEOGAME)) { // Busca pelo DLC do jogo de videogame
                Game g = (Game) item;
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else {
                    for (DLC dlc : g.getDLCs()) {
                        if (dlc.getTitulo().matches(regex)) {
                            lista_search.add(item);
                            break; // Achou um DLC com o termo da busca, sai do loop
                        }
                    }
                }
            } else if (filtro.equals(FiltroItem.TABULEIROTITULO) && item.getTipo().equals(TipoItem.JOGOTABULEIRO)) { // Busca pelo titulo do jogo de tabuleiro
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.TABULEIROESTADO) && item.getTipo().equals(TipoItem.JOGOTABULEIRO)) { // Busca pelo estado do jogo de tabuleiro
                if (termo.isEmpty()) {
                    lista_search.add(item);
                } else if (item.getEstado().getTitulo().matches(regex)) {
                    lista_search.add(item);
                }
            } else if (filtro.equals(FiltroItem.ITEMREPETIDO)) {
                int count = 0;
                for (Item itemOutro : listaDeItens) {
                    if (item.getTitulo().equals(itemOutro.getTitulo()) && item.getTipo().equals(itemOutro.getTipo())) {
                        if (++count > 1) {
                            break;
                        }
                    }
                }
                if (count > 1) {
                    if (termo.isEmpty()) {
                        lista_search.add(item);
                    } else if (item.getTitulo().matches(regex)) {
                        lista_search.add(item);
                    }
                }
                count = 0;
            }
        }
        return lista_search;
    }

    /**
     * Pequisa por HQ.
     *
     * @param id do Objeto HQ a ser pesquisado
     * @return O objeto encontrado, ou null caso não encontre
     * @throws PersonalCollectionsException
     */
    public HQ pesquisarHQ(int id) throws PersonalCollectionsException {
        return hq.pesquisar(id);
    }

    /**
     * Pequisa por Mídia.
     *
     * @param id do Objeto Mídia a ser pesquisado
     * @return O objeto encontrado, ou null caso não encontre
     * @throws PersonalCollectionsException
     */
    public Midia pesquisarMidia(int id) throws PersonalCollectionsException {
        return midia.pesquisar(id);
    }

    /**
     * Pequisa por Game.
     *
     * @param id do objeto Game a ser pesquisado
     * @return O objeto encontrado, ou null caso não encontre
     * @throws PersonalCollectionsException
     */
    public Game pesquisarGame(int id) throws PersonalCollectionsException {
        return game.pesquisar(id);
    }

    /**
     * Pesquisa por tabuleiro
     *
     * @param id id do objeto Tabuleiro a ser pesquisado
     * @return Tabuleiro encontrado
     * @throws PersonalCollectionsException
     */
    public Tabuleiro pesquisarTabuleiro(int id) throws PersonalCollectionsException {
        return tabuleiro.pesquisar(id);
    }

    /**
     * Remove a HQ de acordo como id passado como parametro. Retorna true se a
     * remoção foi bem sucedida ou false caso não. Antes dde tentar remover é
     * verificado se o objeto a ser removido existe. Caso não exista é retornado
     * false
     *
     * Todos os empréstimos cadastrados relacionados ao item também são
     * remvidos.
     *
     * @param id Código da HQ a ser removido
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerHQ(int id) throws PersonalCollectionsException {
        HQ h = hq.pesquisar(id);

        if (h != null) {
            if (hq.remove(h)) {
                atualizarItemAssociadoSerie(h);

                // remove todos os emprestimos relacionados ao item
                removeAllEmprestimoItem(id);
                return true;
            }
        }
        return false;
    }

    /**
     * Atualiza o item que esteja associado a uma série.
     *
     * @param o Item
     * @throws PersonalCollectionsException
     */
    public void atualizarItemAssociadoSerie(Item o) throws PersonalCollectionsException {
        /**
         * Se o item estiver associado com alguma série, ele é sinalizado como
         * não possui o item.
         */
        for (Serie s : listarSeries()) {
            if (s.getItens().contains(o)) {
                Item novoItem = o;
                novoItem.setPossui(false);
                novoItem.setTotalEmprestado(0);
                novoItem.setEmprestado(false);

                s.getItens().set(s.getItens().indexOf(o), novoItem);
                serie.atualizar(s);
            }
        }
    }

    /**
     * Remove a Mídia de acordo como id passado como parametro. Retorna true se
     * a remoção foi bem sucedida ou false caso não. Antes dde tentar remover é
     * verificado se o objeto a ser removido existe. Caso não exista é retornado
     * false
     *
     * Todos os empréstimos cadastrados relacionados ao item também são
     * remvidos.
     *
     * @param id Código da Mídia a ser removida
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerMidia(int id) throws PersonalCollectionsException {
        Midia m = midia.pesquisar(id);
        if (m != null) {
            if (midia.remove(m)) {
                atualizarItemAssociadoSerie(m);

                // remove todos os emprestimos relacionados ao item
                removeAllEmprestimoItem(id);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove o Game de acordo como id passado como parametro. Retorna true se a
     * remoção foi bem sucedida ou false caso não. Antes dde tentar remover é
     * verificado se o objeto a ser removido existe. Caso não exista é retornado
     * false
     *
     * Todos os empréstimos cadastrados relacionados ao item também são
     * remvidos.
     *
     * @param id Código do Game a ser removido
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerGame(int id) throws PersonalCollectionsException {
        Game g = game.pesquisar(id);
        if (g != null) {
            if (game.remove(g)) {
                atualizarItemAssociadoSerie(g);

                // remove todos os emprestimos relacionados ao item
                removeAllEmprestimoItem(id);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove o Tabuleiro de acordo como id passado como parametro. Retorna true
     * se a remoção foi bem sucedida ou false caso não. Antes dde tentar remover
     * é verificado se o objeto a ser removido existe. Caso não exista é
     * retornado false
     *
     * Todos os empréstimos cadastrados relacionados ao item também são
     * remvidos.
     *
     * @param id Código do Tabuleiro a ser removido
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerTabuleiro(int id) throws PersonalCollectionsException {
        Tabuleiro t = tabuleiro.pesquisar(id);
        if (t != null) {
            if (tabuleiro.remove(t)) {
                atualizarItemAssociadoSerie(t);

                // remove todos os emprestimos relacionados ao item
                removeAllEmprestimoItem(id);
                return true;
            }
        }
        return false;
    }

    /**
     * Autentica o usuário Adminn no sistema
     *
     * @param login
     * @param password
     * @return O Usuário caso a autenticação seja bem sucedida ou null caso não
     * seja
     * @throws PersonalCollectionsException
     */
    public Usuario autenticar(String login, char[] password) throws PersonalCollectionsException {
        return usuario.autenticar(login, password);
    }

    /**
     * Recupera os dados do usuário administrador do sistema.
     *
     * @return O Usuario
     */
    public Usuario listarUsuario() {
        return usuario.listar();
    }

    /**
     * Atualiza os dados do usuário.
     *
     * @param u O usuário a ser atualizado
     */
    public void atualizarUsuario(Usuario u) {
        usuario.atualizar(u);
    }

    /**
     * Recpera lista de amigos.
     *
     * @return Lista de amigos
     * @throws PersonalCollectionsException
     */
    public List<Amigo> listarAmigos() throws PersonalCollectionsException {
        listaDeAmigos.clear();
        listaDeAmigos = amigo.listar();

        return listaDeAmigos;
    }

    /**
     * Insere um novo amigo.
     *
     * @param a Amigo a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirAmigo(Amigo a) throws PersonalCollectionsException {
        amigo.save(a);
    }

    /**
     * Atualiza dados do Amigo.
     *
     * @param a Amigo a ser atualizado
     * @throws PersonalCollectionsException
     */
    public void atualizarAmigo(Amigo a) throws PersonalCollectionsException {
        amigo.atualizar(a);
    }

    /**
     * Remove um Amigo de acordo como id passado como parametro. Retorna true se
     * a remoção foi bem sucedida ou false caso não. Antes dde tentar remover é
     * verificado se o objeto a ser removido existe. Caso não exista é retornado
     * false
     *
     * @param id Código do Amigo a ser removido
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerAmigo(int id) throws PersonalCollectionsException {
        Amigo a = amigo.pesquisar(id);
        if (a != null) {
            if (amigo.remove(a)) {
                // remove todos os emprestimos relacionados ao amigo
                removeAllEmprestimoAmigo(id);
                return true;
            }
        }
        return false;
    }

    /**
     * Pesquisa por Amigo
     *
     * @param id do objeto Amigo a ser pesquisado
     * @return O objeto caso encontrado ou null caso não seja
     * @throws PersonalCollectionsException
     */
    public Amigo pesquisarAmigo(int id) throws PersonalCollectionsException {
        return amigo.pesquisar(id);
    }

    /**
     * Recupera lista de emprestimos.
     *
     * @return Lista de Emprestimos
     * @throws PersonalCollectionsException
     */
    public List<Emprestimo> listarEmprestimos() throws PersonalCollectionsException {
        listaDeEmprestimos.clear();
        listaDeEmprestimos = emprestimo.listar();

        return listaDeEmprestimos;
    }

    /**
     * Recupera lista de emprestimos vencidos.
     *
     * @return Lista com os empréstimos vencidos
     * @throws PersonalCollectionsException
     * @throws ParseException
     */
    public List<Emprestimo> listarEmprestimosVencidos() throws PersonalCollectionsException, ParseException {
        List<Emprestimo> listaDeEmprestimosVencidos = new LinkedList<>();
        listaDeEmprestimos.clear();
        listaDeEmprestimos = emprestimo.listar();
        if (listaDeEmprestimos != null && !listaDeEmprestimos.isEmpty()) {
            for (Emprestimo e : listaDeEmprestimos) {
                if (!e.isFinalizado()) {
                    Calendar dataAtual = new GregorianCalendar();
                    Calendar dataRetorno = MyData.stringToCalendar(e.getDataRetono());
                    if (dataAtual.compareTo(dataRetorno) > 0) {
                        listaDeEmprestimosVencidos.add(e);
                    }
                }
            }
        }
        return listaDeEmprestimosVencidos;
    }

    /**
     * Insere um novo empretismo.
     *
     * @param e O Emprestimo a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirEmprestimo(Emprestimo e) throws PersonalCollectionsException {
        emprestimo.save(e);
        atualizarItem(e.getItem());
    }

    /**
     * Atualiza o empretismo.
     *
     * @param e O Emprestimo a ser atualizado
     * @throws PersonalCollectionsException
     */
    public void atualizarEmprestimo(Emprestimo e) throws PersonalCollectionsException {
        emprestimo.atualizar(e);
        atualizarItem(e.getItem());
    }

    /**
     * Pesquisa por empréstimo de acordo com seu id. O objeto empréstimo será
     * retornado caso seja encontrado ou null caso não seja encontrado.
     *
     * @param id Id do empréstimo a ser procurado
     * @return O objeto emprestimo encontrado, ou null caso não encontre
     * @throws PersonalCollectionsException
     */
    public Emprestimo pesquisarEmprestimo(int id) throws PersonalCollectionsException {
        return emprestimo.pesquisar(id);
    }

    /**
     * Remove o empréstimo passado como parãmetro. Como o empréstimo antes
     * cadastrado está sendo apagado o total de vezes que o item foi emprestado
     * é decrementado. Se a remoção for com sucesso será retornado true e false
     * caso não seja.
     *
     * @param e O objeto Empréstimo a ser removido
     * @return Se o empréstimo for removido com sucesso return true, se não
     * return false
     * @throws PersonalCollectionsException
     */
    public boolean removerEmprestimo(Emprestimo e) throws PersonalCollectionsException {
        if (e != null) {
            // Atualiza os dados do item caso o remover o emprestimo foi com sucesso
            if (emprestimo.remove(e)) {
                // Como o emprestimo antes está sendo apagado o total de vezes que o item foi emprestado é decrementado
                e.getItem().decrementaTotalEmprestado();
                e.getItem().setEmprestado(false);
                atualizarItem(e.getItem());
                return true;
            }
        }
        return false;
    }

    /**
     * Remove todos os empréstimos relacionados ao item.
     *
     * @param idItem Id do item removido
     * @throws PersonalCollectionsException
     */
    private void removeAllEmprestimoItem(int idItem) throws PersonalCollectionsException {
        List<Emprestimo> lista = new ArrayList<>(emprestimo.listar());
        if (!lista.isEmpty()) {
            for (Emprestimo e : lista) {
                if (e.getItem() != null && idItem == e.getItem().getId()) {
                    removerEmprestimo(e);
                }
            }
        }
    }

    /**
     * Remove todos os empréstimos relacionados ao amigo.
     *
     * @param idAmigo Id do item removido
     * @throws PersonalCollectionsException
     */
    private void removeAllEmprestimoAmigo(int idAmigo) throws PersonalCollectionsException {
        List<Emprestimo> lista = new ArrayList<>(emprestimo.listar());
        if (!lista.isEmpty()) {
            for (Emprestimo e : lista) {
                if (e.getAmigo() != null && idAmigo == e.getAmigo().getId()) {
                    removerEmprestimo(e);
                }
            }
        }
    }

    /**
     * Finaliza o empréstimo. Ou seja, o empréstimo será sinalizado como
     * finalizado e o item do empréstimo ficará disponível para novos
     * empréstimos.
     *
     * @param e O objeto Emprestimo
     * @throws PersonalCollectionsException
     */
    public void finalizarEmprestimo(Emprestimo e) throws PersonalCollectionsException {
        if (e != null) {
            // Item devolvido
            e.getItem().setEmprestado(false);
            e.setFinalizado(true);
            emprestimo.atualizar(e);
            atualizarItem(e.getItem());
        }
    }

    /**
     * Utilizado o insertionSort
     *
     * @return
     * @throws PersonalCollectionsException
     */
    public List<Item> rankingEmprestimo() throws PersonalCollectionsException {
        int i = 0;
        List<Item> lista = new ArrayList<>(listarItens());

        for (int j = 1; j < lista.size(); j++) {
            Item eleito = lista.get(j);
            i = j - 1;
            while (i >= 0 && lista.get(i).getTotalEmprestado() < eleito.getTotalEmprestado()) {
                lista.set((i + 1), lista.get(i));
                i--;
            }
            lista.set((i + 1), eleito);
        }

        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

    /**
     * Utilizado o insertionSort
     *
     * @return
     * @throws PersonalCollectionsException
     */
    public List<Item> rankingNota() throws PersonalCollectionsException {
        int i = 0;
        List<Item> lista = new ArrayList<>(listarItens());
        for (int j = 1; j < lista.size(); j++) {
            Item eleito = lista.get(j);
            i = j - 1;
            while (i >= 0 && lista.get(i).getNota() < eleito.getNota()) {
                lista.set((i + 1), lista.get(i));
                i--;
            }
            lista.set((i + 1), eleito);
        }

        if (!lista.isEmpty()) {
            return lista;
        } else {
            return null;
        }
    }

    /**
     * Percorre a lista de itens e seta o auto_icrement com o maior id (último)
     * cadastrado.
     *
     */
    public void setIdItem() {
        try {
            int max = 0;
            listaDeItens = listarItens();
            for (Item item : listaDeItens) {
                if (item.getId() > max) {
                    max = item.getId();
                }
            }
            Item.setAuto_increment(max);
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Percorre a lista de amigos e seta o auto_icrement com o maior id (último)
     * cadastrado.
     *
     */
    public void setIdAmigo() {
        try {
            int max = 0;
            listaDeAmigos = listarAmigos();
            for (Pessoa p : listaDeAmigos) {
                if (p.getId() > max) {
                    max = p.getId();
                }
            }
            Pessoa.setAuto_increment(max);
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Percorre a lista de series e seta o auto_icrement com o maior id (último)
     * cadastrado.
     *
     */
    public void setIdSerie() {
        try {
            int max = 0;
            listaDeSeries = listarSeries();
            for (Serie s : listaDeSeries) {
                if (s.getId() > max) {
                    max = s.getId();
                }
            }
            Serie.setAuto_increment(max);
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Percorre a lista de emprestimos e seta o auto_increment com o maior id
     * (último) cadastrado.
     *
     * @throws PersonalCollectionsException
     */
    public void setIdEmprestimo() {
        try {
            int max = 0;
            listaDeEmprestimos = listarEmprestimos();

            for (Emprestimo emp : listaDeEmprestimos) {
                if (emp.getId() > max) {
                    max = emp.getId();
                }
            }
            Emprestimo.setAuto_increment(max);
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Checa se tem item cadastrado
     *
     * @return
     */
    public boolean temItem() {
        return listaDeItens.isEmpty();
    }

    /**
     * Limpa lista de items
     */
    public void cleanItems() throws PersonalCollectionsException {
        listarItens().clear();
    }

    /**
     * Retorna lista de séries cadastradas.
     *
     * @return @throws PersonalCollectionsException
     */
    public List<Serie> listarSeries() throws PersonalCollectionsException {
        listaDeSeries.clear();
        listaDeSeries = serie.listar();
        return listaDeSeries;
    }

    /**
     * Insere uma nova serie.
     *
     * @param s Serie a ser inserida
     * @throws PersonalCollectionsException
     */
    public void inserirSerie(Serie s) throws PersonalCollectionsException {
        serie.save(s);
    }

    /**
     * Atualiza série.
     *
     * @param s Serie a ser atualizada
     * @throws PersonalCollectionsException
     */
    public void atualizarSerie(Serie s) throws PersonalCollectionsException {
        serie.atualizar(s);
    }

    /**
     * Remove uma série de acordo com o id.
     *
     * @param id Código da Série a ser removida
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerSerie(int id) throws PersonalCollectionsException {
        Serie s = serie.pesquisar(id);
        if (s != null) {
            if (serie.remove(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna lista com os itens que estão disponíveis para cadastro de novas
     * séries. Se um item estiver cadastrado em alguma série ele automaticamente
     * estará indisponivel par anovas séries.
     *
     * @return <code>List<Item> </code> Lista com os itens disponíveis
     * @throws PersonalCollectionsException
     */
    public List<Item> getItensDisponivelSerie() throws PersonalCollectionsException {
        List<Item> result = new LinkedList<>();
        listarSeries();

        for (Item item : listarItens()) {
            boolean flag = false;

            for (Serie s : listarSeries()) {
                if (s.getItens().contains(item) && flag != true) {
                    flag = true;
                }
            }
            if (!flag) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Pesquisa por Série
     *
     * @param id do objeto Série a ser pesquisado
     * @return O objeto caso encontrado ou null caso não seja encontrado
     * @throws PersonalCollectionsException
     */
    public Serie pesquisarSerie(int id) throws PersonalCollectionsException {
        return serie.pesquisar(id);
    }

    /**
     * Retorna lista de desejo cadastrada.
     *
     * @return @throws PersonalCollectionsException
     */
    public List<ListaDeDesejo> listarListaDeDesejo() throws PersonalCollectionsException {
        listaDeDesejos.clear();
        listaDeDesejos = whishlist.listar();
        return listaDeDesejos;
    }

    /**
     * Retorna lista de desejo com itens disponíveis para compra de acordo com a
     * data de lançamento.
     *
     * @return @throws PersonalCollectionsException
     */
    public List<ListaDeDesejo> listarListaDeDesejoDisponiveis() throws PersonalCollectionsException, ParseException {
        List<ListaDeDesejo> listaDesejoisponivel = new LinkedList<>();
        // garante o listar
        listarListaDeDesejo();

        for (ListaDeDesejo l : listaDeDesejos) {
            // se houver data de lançamento
            if (!("".equals(l.getDataDeLancamento()))) {
                Calendar dataAtual = new GregorianCalendar();
                Calendar dataLancamento = MyData.stringToCalendar(l.getDataDeLancamento());
                if (dataAtual.compareTo(dataLancamento) != -1) {
                    listaDesejoisponivel.add(l);
                }

            }
        }
        return listaDesejoisponivel;
    }

    /**
     * Insere um novo item na lista de desejo.
     *
     * @param o ListaDeDesejo contendo o item a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirItemListaDeDesejo(ListaDeDesejo o) throws PersonalCollectionsException {
        whishlist.save(o);
    }

    /**
     * Atualiza item da lista de desejo.
     *
     * @param o ListaDeDesejo contendo o item a ser atualizado
     * @throws PersonalCollectionsException
     */
    public void atualizarItemListaDeDesejo(ListaDeDesejo o) throws PersonalCollectionsException {
        whishlist.atualizar(o);
    }

    /**
     * Remove o item da Lista de Desejo de acordo com o id do item.
     *
     * @param ListaDeDesejo Objeto contendo item a ser removido da lista de
     * desejo
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerItemListaDeDesejo(ListaDeDesejo o) throws PersonalCollectionsException {
        if (whishlist.remove(o)) {
            return true;
        }
        return false;
    }

    /**
     * Pesquisa por item na lista de desejo.
     *
     * @param String Título do Item a ser pesquisado
     * @return ListaDeDesejo contendo Item caso encontrado ou null caso não seja
     * encontrado
     * @throws PersonalCollectionsException
     */
    public ListaDeDesejo pesquisarItemListaDeDesejo(String titulo) throws PersonalCollectionsException {
        return whishlist.pesquisar(titulo);
    }
}
