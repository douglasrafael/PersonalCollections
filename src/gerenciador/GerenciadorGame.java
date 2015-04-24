package gerenciador;

import java.util.LinkedList;
import java.util.List;

import tipos.Game;
import excecoes.PersonalCollectionsException;

public class GerenciadorGame implements Gerenciador<Game> {

    private List<Game> listaDeGames;

    public GerenciadorGame() {
        listaDeGames = new LinkedList<>();
    }

    @Override
    public List<Game> listar() throws PersonalCollectionsException {
        return listaDeGames;
    }

    @Override
    public void save(Game o) throws PersonalCollectionsException {
        listaDeGames.add(o);
    }

    @Override
    public void atualizar(Game o) throws PersonalCollectionsException {
        if (!listaDeGames.isEmpty()) {
            Game m = pesquisar(o);
            if (m != null) {
                listaDeGames.set(listaDeGames.indexOf(m), o);
            }
        }
    }

    @Override
    public boolean remove(Game o) throws PersonalCollectionsException {
        return listaDeGames.remove(o);
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
     * Procura Game utilizando o equals. Caso não seja encontrado o item é
     * retornado null.
     *
     * @param o O objeto Game a ser procurado
     * @return O objeto Game encontrado ou null caso não seja
     */
    public Game pesquisar(Game o) {
        if (!listaDeGames.isEmpty()) {
            for (Game g : listaDeGames) {
                if (g.equals(o)) {
                    return g;
                }
            }
        }
        return null;
    }
}
