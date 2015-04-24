package gerenciador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tipos.HQ;
import excecoes.PersonalCollectionsException;

public class GerenciadorHQ implements Gerenciador<HQ> {

    private List<HQ> listaDeHQs;

    public GerenciadorHQ() {
        listaDeHQs = new ArrayList<>();
    }

    @Override
    public List<HQ> listar() throws PersonalCollectionsException {
        return listaDeHQs;
    }

    @Override
    public void save(HQ o) throws PersonalCollectionsException {
        listaDeHQs.add(o);
    }

    @Override
    public void atualizar(HQ o) throws PersonalCollectionsException {
        if (!listaDeHQs.isEmpty()) {
            HQ hq = pesquisar(o);
            if (hq != null) {
                listaDeHQs.set(listaDeHQs.indexOf(hq), o);
            }
        }
    }

    @Override
    public boolean remove(HQ o) throws PersonalCollectionsException {
        return listaDeHQs.remove(o);
    }

    /**
     * Procura HQs pelo título. Caso não seja encontrado nenhum item, a lista é
     * retornada vazia. Método útil quando se quer listar todos os HQs que tem
     * título igual ou parecido, mais que são diferentes
     * 
     * @param titulo_item O título do HQ a ser procurado
     * @return Lista com HQs encontrados
     */
    public List<HQ> pesquisar(String titulo_item) {
        List<HQ> itemsEncontardos = new LinkedList<>();
        if (!listaDeHQs.isEmpty()) {
            for (HQ hq : listaDeHQs) {
                /**
                 * Verifica se o titulo do HQ estar contido no título do HQ da
                 * vez Se estiver contido o HQ é adicionado na lista de items
                 * encontrados
                 */
                if (hq.getTitulo().toLowerCase().contains(titulo_item.toLowerCase())) {
                    itemsEncontardos.add(hq);
                }
            }
        }
        return itemsEncontardos;
    }

    /**
     * Procura HQ utilizando o equals. Caso não seja encontrado o item é
     * retornado null.
     *
     * @param o O objeto HQ a ser procurado
     * @return O objeto HQ encontrado ou null caso não seja
     */
    public HQ pesquisar(HQ o) {
        if (!listaDeHQs.isEmpty()) {
            for (HQ hq : listaDeHQs) {
                if (hq.equals(o)) {
                    return hq;
                }
            }
        }
        return null;
    }
}
