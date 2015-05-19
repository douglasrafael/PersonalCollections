package br.edu.uepb.personalcollections.dao;

import java.util.LinkedList;
import java.util.List;

import br.edu.uepb.personalcollections.Game;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameDAO implements DAO<Game> {

    private static List<Game> listaDeGames = new LinkedList<>();
    private Serializador ser;
    private final String PATH = "data/data_game.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public GameDAO() {
        this.ser = new Serializador();
    }

    @Override
    public List<Game> listar() throws PersonalCollectionsException {
        if(listaDeGames.isEmpty()) {
            deserializar();
        }
        return listaDeGames;
    }

    @Override
    public void save(Game o) throws PersonalCollectionsException {
        listaDeGames.add(o);
        serializar();
    }

    @Override
    public void atualizar(Game o) throws PersonalCollectionsException {
        if (!listaDeGames.isEmpty()) {
            Game m = pesquisar(o);
            if (m != null) {
                listaDeGames.set(listaDeGames.indexOf(m), o);
                serializar();
            }
        }
    }

    @Override
    public boolean remove(Game o) throws PersonalCollectionsException {
        boolean result = listaDeGames.remove(o);
        serializar();
        return result;
    }

    /**
     * Procura Game pelo título. Caso não seja encontrado nenhum item, a lista é
     * retornada vazia. Método útil quando se quer listar todas os games que tem
     * título igual ou parecido, mais que são diferentes
     *
     * @param titulo_item
     * @return Lista com Games encontrados
     */
    public List<Game> pesquisar(String titulo_item) {
        List<Game> itemsEncontardos = new LinkedList<>();
        if (!listaDeGames.isEmpty()) {
            for (Game g : listaDeGames) {
                /**
                 * Verifica se o titulo do Game estar contido no título do Game
                 * da vez Se estiver contido o Game é adicionado na lista de
                 * items encontrados
                 */
                if (g.getTitulo().toLowerCase().contains(titulo_item.toLowerCase())) {
                    itemsEncontardos.add(g);
                }
            }
        }
        return itemsEncontardos;
    }

    /**
     * Procura Game utilizando o id. Caso não seja encontrado o item é retornado
     * null.
     *
     * @param id O id do Game a ser procurado
     * @return O objeto Game encontrado ou null caso não seja
     */
    @Override
    public Game pesquisar(int id) {
        if (!listaDeGames.isEmpty()) {
            for (Game g : listaDeGames) {
                if (g.getId() == id) {
                    return g;
                }
            }
        }
        return null;
    }

    /**
     * Procura Game utilizando o objeto. Caso não seja encontrado o item é
     * retornado null.
     *
     * @param game O Objeto do Game a ser procurado
     * @return O objeto Game encontrado ou null caso não seja
     */
    public Game pesquisar(Game game) {
        if (!listaDeGames.isEmpty()) {
            for (Game g : listaDeGames) {
                if (g.equals(game)) {
                    return g;
                }
            }
        }
        return null;
    }

    @Override
    public void serializar() {
        try {
            ser.serializar(PATH, listaDeGames);
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            if (o != null) {
                listaDeGames = (LinkedList<Game>) o;
            }
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
