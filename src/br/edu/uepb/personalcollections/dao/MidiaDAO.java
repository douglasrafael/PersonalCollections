package br.edu.uepb.personalcollections.dao;

import java.util.LinkedList;
import java.util.List;

import br.edu.uepb.personalcollections.Midia;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contém as implementações de: (listar, buscar, inserir, atualizar, deletar, serializar, deserializar...) referente ao tipo Midia 
 * 
 * @author Douglas Rafael
 */
public class MidiaDAO implements DAO<Midia> {

    private static List<Midia> listaDeMidias = new LinkedList<>();
    private Serializador ser;
    private final String PATH = "data/data_midia.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public MidiaDAO() {
        this.ser = new Serializador();
    }

    @Override
    public List<Midia> listar() throws PersonalCollectionsException {
        if (listaDeMidias.isEmpty()) {
            deserializar();
        }
        return listaDeMidias;
    }

    @Override
    public void save(Midia o) throws PersonalCollectionsException {
        listaDeMidias.add(o);
        serializar();
    }

    @Override
    public void atualizar(Midia o) throws PersonalCollectionsException {
        if (!listaDeMidias.isEmpty()) {
            Midia m = pesquisar(o);
            if (m != null) {
                listaDeMidias.set(listaDeMidias.indexOf(m), o);
                serializar();
            }
        }
    }

    @Override
    public boolean remove(Midia o) throws PersonalCollectionsException {
        boolean result = listaDeMidias.remove(o);
        if (result) {
            serializar();
        }
        return result;
    }

    /**
     * Procura Mídia pelo título. Caso não seja encontrado nenhum item, a lista
     * é retornada vazia. Método útil quando se quer listar todas as Mídias que
     * tem título igual ou parecido, mais que são diferentes
     *
     * @param titulo_item O título da Mídia a ser procurada
     * @return Lista com Mídias encontradas
     */
    public List<Midia> pesquisar(String titulo_item) {
        List<Midia> itemsEncontardos = new LinkedList<>();
        if (!listaDeMidias.isEmpty()) {
            for (Midia m : listaDeMidias) {
                /**
                 * Verifica se o titulo da Mídia estar contido no título da
                 * Mídia da vez Se estiver contido a Mídia é adicionada na lista
                 * de items encontrados
                 */
                if (m.getTitulo().toLowerCase().contains(titulo_item.toLowerCase())) {
                    itemsEncontardos.add(m);
                }
            }
        }
        return itemsEncontardos;
    }

    /**
     * Procura Mídia utilizando o id. Caso não seja encontrado o item é
     * retornado null.
     *
     * @param id O id da Mídia a ser procurada
     * @return O objeto Mídia encontrado ou null caso não seja
     */
    @Override
    public Midia pesquisar(int id) {
        if (!listaDeMidias.isEmpty()) {
            for (Midia m : listaDeMidias) {
                if (m.getId() == id) {
                    return m;
                }
            }
        }
        return null;
    }

    /**
     * Pesquisa utilizando o objeto
     *
     * @param midia A midia a ser pesquisada
     * @return O objeto midia se encontrado ou null caso não seja
     */
    public Midia pesquisar(Midia midia) {
        if (!listaDeMidias.isEmpty()) {
            for (Midia m : listaDeMidias) {
                if (m.equals(midia)) {
                    return m;
                }
            }
        }
        return null;
    }

    @Override
    public void serializar() {
        try {
            ser.serializar(PATH, listaDeMidias);
        } catch (IOException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            if (o != null) {
                listaDeMidias = (LinkedList<Midia>) o;
            }
        } catch (IOException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
