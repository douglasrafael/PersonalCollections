package gerenciador;

import dao.AmigoDAO;
import dao.EmprestimoDAO;
import dao.GameDAO;
import dao.HqDAO;
import dao.MidiaDAO;
import dao.TabuleiroDAO;
import dao.UsuarioDAO;
import enums.TipoItem;
import excecoes.PersonalCollectionsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tipos.Amigo;
import tipos.Emprestimo;
import tipos.Game;
import tipos.HQ;
import tipos.Item;
import tipos.Midia;
import tipos.Tabuleiro;
import tipos.Usuario;

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

    private static List<Item> listaDeItens = new ArrayList<>();

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
        if (!listartabuleiros().isEmpty()) {
            listaDeItens.addAll(listartabuleiros());
        }
        return listaDeItens;
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
     * Pesquisa por item
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
     * @param id Código da HQ a ser removido
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerHQ(int id) throws PersonalCollectionsException {
        HQ h = hq.pesquisar(id);
        if (h != null) {
            return hq.remove(h);
        } else {
            return false;
        }
    }

    /**
     * Remove a Mídia de acordo como id passado como parametro. Retorna true se
     * a remoção foi bem sucedida ou false caso não. Antes dde tentar remover é
     * verificado se o objeto a ser removido existe. Caso não exista é retornado
     * false
     *
     * @param id Código da Mídia a ser removida
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerMidia(int id) throws PersonalCollectionsException {
        Midia m = midia.pesquisar(id);
        if (m != null) {
            return midia.remove(m);
        } else {
            return false;
        }
    }

    /**
     * Remove o Game de acordo como id passado como parametro. Retorna true se a
     * remoção foi bem sucedida ou false caso não. Antes dde tentar remover é
     * verificado se o objeto a ser removido existe. Caso não exista é retornado
     * false
     *
     * @param id Código do Game a ser removido
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerGame(int id) throws PersonalCollectionsException {
        Game g = game.pesquisar(id);
        if (g != null) {
            return game.remove(g);
        } else {
            return false;
        }
    }

    /**
     * Remove o Tabuleiro de acordo como id passado como parametro. Retorna true
     * se a remoção foi bem sucedida ou false caso não. Antes dde tentar remover
     * é verificado se o objeto a ser removido existe. Caso não exista é
     * retornado false
     *
     * @param id Código do Tabuleiro a ser removido
     * @return true se a remoção foi bem sucedida e false caso não foi
     * @throws PersonalCollectionsException
     */
    public boolean removerTabuleiro(int id) throws PersonalCollectionsException {
        Tabuleiro t = tabuleiro.pesquisar(id);
        if (t != null) {
            return tabuleiro.remove(t);
        } else {
            return false;
        }
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
    public Usuario autenticar(String login, String password) throws PersonalCollectionsException {
        return usuario.autenticar(login, password);
    }

    /**
     * Recpera lista de amigos.
     *
     * @return Lista de amigos
     * @throws PersonalCollectionsException
     */
    public List<Amigo> listarAmigos() throws PersonalCollectionsException {
        return amigo.listar();
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
            return amigo.remove(a);
        } else {
            return false;
        }
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
        return emprestimo.listar();
    }

    /**
     * Insere um novo empretismo.
     *
     * @param e O Emprestimo a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirEmprestimo(Emprestimo e) throws PersonalCollectionsException {
        emprestimo.save(e);
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

}
