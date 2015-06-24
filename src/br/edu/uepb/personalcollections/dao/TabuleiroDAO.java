package br.edu.uepb.personalcollections.dao;

import java.util.LinkedList;
import java.util.List;

import br.edu.uepb.personalcollections.Tabuleiro;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contém as implementações de: (listar, buscar, inserir, atualizar, deletar, serializar, deserializar...) referente ao tipo Tabuleiro 
 * 
 * @author Douglas Rafael
 */
public class TabuleiroDAO implements DAO<Tabuleiro> {

    private static List<Tabuleiro> listaDeJogosTabuleiro = new LinkedList<>();
    private Serializador ser;
    private final String PATH = "data/data_tabuleiro.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public TabuleiroDAO() {
        this.ser = new Serializador();
    }

    @Override
    public List<Tabuleiro> listar() throws PersonalCollectionsException {
        if (listaDeJogosTabuleiro.isEmpty()) {
            deserializar();
        }
        return listaDeJogosTabuleiro;
    }

    @Override
    public void save(Tabuleiro o) throws PersonalCollectionsException {
        listaDeJogosTabuleiro.add(o);
        serializar();
    }

    @Override
    public void atualizar(Tabuleiro o) throws PersonalCollectionsException {
        if (!listaDeJogosTabuleiro.isEmpty()) {
            Tabuleiro t = pesquisar(o);
            if (t != null) {
                listaDeJogosTabuleiro.set(listaDeJogosTabuleiro.indexOf(t), o);
                serializar();
            }
        }
    }

    @Override
    public boolean remove(Tabuleiro o) throws PersonalCollectionsException {
        boolean result = listaDeJogosTabuleiro.remove(o);
        if (result) {
            serializar();
        }
        return result;
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

    @Override
    public void serializar() {
        try {
            ser.serializar(PATH, listaDeJogosTabuleiro);
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            if (o != null) {
                listaDeJogosTabuleiro = (LinkedList<Tabuleiro>) o;
            }
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TabuleiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
