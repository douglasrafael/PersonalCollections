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
import br.edu.uepb.personalcollections.Amigo;
import br.edu.uepb.personalcollections.Emprestimo;
import br.edu.uepb.personalcollections.Game;
import br.edu.uepb.personalcollections.HQ;
import br.edu.uepb.personalcollections.Item;
import br.edu.uepb.personalcollections.Midia;
import br.edu.uepb.personalcollections.Pessoa;
import br.edu.uepb.personalcollections.Tabuleiro;
import br.edu.uepb.personalcollections.Usuario;
import java.util.LinkedList;

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

    private static List<Item> listaDeItens = new LinkedList<>();
    private List<Amigo> listaDeAmigos;
    private List<Emprestimo> listaDeEmprestimos = new LinkedList<>();

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
        if (listartabuleiros() != null && !listartabuleiros().isEmpty()) {
            listaDeItens.addAll(listartabuleiros());
        }

        // Seta o auto_increment caso ele não esteja setado
        if (Item.getAuto_increment() == 0) {
            setIdItem();
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

        // Atualiza também o item que está associado ao emprestimo
//        if (listaDeEmprestimos.isEmpty()) {
//            listarEmprestimos();
//            if (!listaDeEmprestimos.isEmpty()) {
//                emprestimo.serializar();
//            }
//        }
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
                // remove todos os emprestimos relacionados ao item
                removeAllEmprestimoItem(id);
                return true;
            }
        }
        return false;

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
                // remove todos os emprestimos relacionados ao item
//                removeAllEmprestimoItem(id);
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
        listaDeAmigos = new LinkedList<>(amigo.listar());

        // Seta o auto_increment caso ele não esteja setado
        if (Pessoa.getAuto_increment() == 0) {
            setIdAmigo();
        }
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
        listaDeEmprestimos = emprestimo.listar();

        // Seta o auto_increment caso ele não esteja setado
        if (Emprestimo.getAuto_increment() == 0) {
            setIdEmprestimo();
        }
        return listaDeEmprestimos;
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
                if (e.getItem().isEmprestado()) {
                    e.getItem().setEmprestado(false);
                }
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
                if(e.getItem() != null && idItem == e.getItem().getId()) {
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
            if (!e.isFinalizado()) {
                e.setFinalizado(true);
            }
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
     * @throws PersonalCollectionsException
     */
    public void setIdItem() throws PersonalCollectionsException {
        int max = 0;
        for (Item item : listaDeItens) {
            if (item.getId() > max) {
                max = item.getId();
            }
        }
        Item.setAuto_increment(max);
    }

    /**
     * Percorre a lista de amigos e seta o auto_icrement com o maior id (último)
     * cadastrado.
     *
     * @throws PersonalCollectionsException
     */
    public void setIdAmigo() throws PersonalCollectionsException {
        int max = 0;
        for (Pessoa pessoa : listaDeAmigos) {
            if (pessoa.getId() > max) {
                max = pessoa.getId();
            }
        }
        Pessoa.setAuto_increment(max);
    }

    /**
     * Percorre a lista de emprestimos e seta o auto_increment com o maior id
     * (último) cadastrado.
     *
     * @throws PersonalCollectionsException
     */
    public void setIdEmprestimo() throws PersonalCollectionsException {
        int max = 0;
        for (Emprestimo emp : listaDeEmprestimos) {
            if (emp.getId() > max) {
                max = emp.getId();
            }
        }
        Emprestimo.setAuto_increment(max);
    }
}
