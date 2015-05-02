package dao;

import java.util.LinkedList;
import java.util.List;

import tipos.Tabuleiro;
import excecoes.PersonalCollectionsException;

public class TabuleiroDAO implements DAO<Tabuleiro> {

    private static List<Tabuleiro> listaDeJogosTabuleiro = new LinkedList<>();

    @Override
    public List<Tabuleiro> listar() throws PersonalCollectionsException {
        return listaDeJogosTabuleiro;
    }

    @Override
    public void save(Tabuleiro o) throws PersonalCollectionsException {
        listaDeJogosTabuleiro.add(o);
    }

    @Override
    public void atualizar(Tabuleiro o) throws PersonalCollectionsException {
        if (!listaDeJogosTabuleiro.isEmpty()) {
            Tabuleiro t = pesquisar(o);
            if (t != null) {
                listaDeJogosTabuleiro.set(listaDeJogosTabuleiro.indexOf(t), o);
            }
        }
    }

    @Override
    public boolean remove(Tabuleiro o) throws PersonalCollectionsException {
        return listaDeJogosTabuleiro.remove(o);
    }

    /**
     * Procura Tabuleiro pelo título. Caso não seja encontrado nenhum Tabuleiro,
     * a lista é retornada vazia. Método útil quando se quer listar todos os
     * Tabuleiros que tem título igual ou parecido, mais que são diferentes
     *
     * @param titulo_item O título do Tabuleiro a ser procurado
     * @return Lista com Tabuleiros encontrados
     */
    public List<Tabuleiro> pesquisar(String titulo_item) {
        List<Tabuleiro> itemsEncontardos = new LinkedList<>();
        if (!listaDeJogosTabuleiro.isEmpty()) {
            for (Tabuleiro t : listaDeJogosTabuleiro) {
                /**
                 * Verifica se o titulo do item estar contido no título do
                 * objeto da vez Se estiver contido o objeto é adicionado na
                 * lista de items encontrados
                 */
                if (t.getTitulo().toLowerCase().contains(titulo_item.toLowerCase())) {
                    itemsEncontardos.add(t);
                }
            }
        }
        return itemsEncontardos;
    }

    /**
     * Procura Tabuleiro pelo id passado como parâmetro. Caso não seja
     * encontrado o Tabuleiro é retornado null.
     *
     * @param id
     * @return O objeto Tabuleiro encontrado ou null caso não seja
     * @throws PersonalCollectionsException
     */
    @Override
    public Tabuleiro pesquisar(int id) throws PersonalCollectionsException {
        if (!listaDeJogosTabuleiro.isEmpty()) {
            for (Tabuleiro t : listaDeJogosTabuleiro) {
                if (t.getId() == id) {
                    return t;
                }
            }
        }
        return null;
    }
    
    /**
     * Procura Tabuleiro pelo objeto passado como parâmetro. Caso não seja
     * encontrado o Tabuleiro é retornado null.
     *
     * @param tab
     * @return O objeto Tabuleiro encontrado ou null caso não seja
     * @throws PersonalCollectionsException
     */
    public Tabuleiro pesquisar(Tabuleiro tab) throws PersonalCollectionsException {
        if (!listaDeJogosTabuleiro.isEmpty()) {
            for (Tabuleiro t : listaDeJogosTabuleiro) {
                if (t.equals(tab)) {
                    return t;
                }
            }
        }
        return null;
    }
}
