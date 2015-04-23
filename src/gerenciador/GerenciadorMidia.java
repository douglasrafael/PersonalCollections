package gerenciador;

import java.util.LinkedList;
import java.util.List;

import tipos.Midia;
import excecoes.PersonalCollectionsException;

public class GerenciadorMidia implements Gerenciador<Midia> {

    private List<Midia> listaDeMidias;

    public GerenciadorMidia() {
        listaDeMidias = new LinkedList<Midia>();
    }

    @Override
    public List<Midia> listar() throws PersonalCollectionsException {
        return listaDeMidias;
    }

    @Override
    public void save(Midia o) throws PersonalCollectionsException {
        listaDeMidias.add(o);
    }

    @Override
    public void atualizar(Midia o) throws PersonalCollectionsException {
        if (!listaDeMidias.isEmpty()) {
            Midia m = pesquisar(o);
            if (m != null) {
                listaDeMidias.set(listaDeMidias.indexOf(m), o);
            }
        }
    }

    @Override
    public boolean remove(Midia o) throws PersonalCollectionsException {
        return listaDeMidias.remove(o);
    }

    /**
     * Procura Mídia pelo título. Caso não seja encontrado nenhum item, a lista
     * é retornada vazia. Método útil quando se quer listar todas as Mídias que
     * tem título igual ou parecido, mais que são diferentes
     *
     * @param titulo_item O título da Mídia a ser procurada
     * @return Lista com Mídias encontradas
     */
    /**
     */
    public List<Midia> pesquisar(String titulo_item) {
        List<Midia> itemsEncontardos = new LinkedList<Midia>();
        if (!listaDeMidias.isEmpty()) {
            for (Midia m : listaDeMidias) {
                /**
                 * Verifica se o titulo da Mídia estar contido no título da
                 * Mídia da vez Se estiver contido a Mídia é adicionada na lista
                 * de items encontrados
                 */
                if (m.getTitulo().toLowerCase().indexOf(titulo_item.toLowerCase()) != -1) {
                    itemsEncontardos.add(m);
                }
            }
        }
        return itemsEncontardos;
    }

    /**
     * Procura Mídia utilizando o equals. Caso não seja encontrado o item é
     * retornado null.
     *
     * @param o O objeto Mídia a ser procurado
     * @return O objeto Mídia encontrado ou null caso não seja
     */
    public Midia pesquisar(Midia o) {
        if (!listaDeMidias.isEmpty()) {
            for (Midia m : listaDeMidias) {
                if (m.equals(o)) {
                    return m;
                }
            }
        }
        return null;
    }
}
