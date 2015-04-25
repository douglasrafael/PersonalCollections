package gerenciador;

import dao.AmigoDAO;
import dao.GameDAO;
import dao.HqDAO;
import dao.MidiaDAO;
import dao.TabuleiroDAO;
import excecoes.PersonalCollectionsException;
import java.util.LinkedList;
import java.util.List;
import tipos.Amigo;
import tipos.Game;
import tipos.HQ;
import tipos.Item;
import tipos.Midia;
import tipos.Tabuleiro;

/**
 * Classe gerenciador
 *
 * @author Douglas Rafael
 */
public class Gerenciador {

    private final AmigoDAO amigo;
    private final HqDAO hq;
    private final MidiaDAO midia;
    private final GameDAO game;
    private final TabuleiroDAO tabuleiro;

    /**
     * Método construtor, cria as instâncias dos DAOs.
     */
    public Gerenciador() {
        amigo = new AmigoDAO();
        hq = new HqDAO();
        midia = new MidiaDAO();
        game = new GameDAO();
        tabuleiro = new TabuleiroDAO();
    }

    /**
     * Recupera uma lista completa de todos os itens. Caso não tenha nenhum item, a lista é retornada vazia.
     * 
     * @return A lista com todos os items
     * @throws PersonalCollectionsException 
     */
    public List<Item> listarItens() throws PersonalCollectionsException {
        List<Item> itens = new LinkedList<>();
        if (!listarHQs().isEmpty()) {
            itens.addAll(listarHQs());
        }
        if (!listarMidias().isEmpty()) {
            itens.addAll(listarMidias());
        }
        if (!listarGames().isEmpty()) {
            itens.addAll(listarGames());
        }
        if(!listartabuleiros().isEmpty()) {
            itens.addAll(listartabuleiros());
        }
            return itens;
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
     * Insere um novo amigo.
     *
     * @param a Amigo a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirAmigo(Amigo a) throws PersonalCollectionsException {
        amigo.save(a);
    }

    /**
     * Insere uma noca HQ.
     *
     * @param h HQ a ser inserida
     * @throws PersonalCollectionsException
     */
    public void inserirHQ(HQ h) throws PersonalCollectionsException {
        hq.save(h);
    }

    /**
     * Insere uma nova Mídia.
     *
     * @param m Mídia a ser inserida
     * @throws PersonalCollectionsException
     */
    public void inserirMidia(Midia m) throws PersonalCollectionsException {
        midia.save(m);
    }

    /**
     * Insere um novo jogo de Vidiogame.
     *
     * @param g Game a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirGame(Game g) throws PersonalCollectionsException {
        game.save(g);
    }

    /**
     * Insere uma novo jogo de Tabuleiro.
     *
     * @param t Tabuleiro a ser inserido
     * @throws PersonalCollectionsException
     */
    public void inserirTabuleiro(Tabuleiro t) throws PersonalCollectionsException {
        tabuleiro.save(t);
    }
}
