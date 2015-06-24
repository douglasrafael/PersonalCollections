package br.edu.uepb.personalcollections.dao;

import java.util.LinkedList;
import java.util.List;

import br.edu.uepb.personalcollections.HQ;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contém as implementações de: (listar, buscar, inserir, atualizar, deletar, serializar, deserializar...) referente ao tipo HQ 
 * 
 * @author Douglas Rafael
 */
public class HqDAO implements DAO<HQ> {

    private static List<HQ> listaDeHQs = new LinkedList<>();

    private Serializador ser;
    private final String PATH = "data/data_hq.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public HqDAO() {
        this.ser = new Serializador();
    }

    @Override
    public List<HQ> listar() throws PersonalCollectionsException {
        if (listaDeHQs.isEmpty()) {
            deserializar();
        }
        return listaDeHQs;
    }

    @Override
    public void save(HQ o) throws PersonalCollectionsException {
        listaDeHQs.add(o);
        serializar();
    }

    @Override
    public void atualizar(HQ o) throws PersonalCollectionsException {
        if (!listaDeHQs.isEmpty()) {
            HQ hq = pesquisar(o);
            if (hq != null) {
                listaDeHQs.set(listaDeHQs.indexOf(hq), o);
                serializar();
            }
        }
    }

    @Override
    public boolean remove(HQ o) throws PersonalCollectionsException {
        boolean result = listaDeHQs.remove(o);
        if (result) {
            serializar();
        }
        return result;
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
     * Procura HQ utilizando o id. Caso não seja encontrado o item é retornado
     * null.
     *
     * @param id O id da HQ a ser procurada
     * @return O objeto HQ encontrado ou null caso não seja
     */
    @Override
    public HQ pesquisar(int id) {
        if (!listaDeHQs.isEmpty()) {
            for (HQ hq : listaDeHQs) {
                if (hq.getId() == id) {
                    return hq;
                }
            }
        }
        return null;
    }

    /**
     * Procura HQ utilizando o objeto. Caso não seja encontrado o item é
     * retornado null.
     *
     * @param hq O Objeto HQ a ser procurada
     * @return O objeto HQ encontrado ou null caso não seja
     */
    public HQ pesquisar(HQ hq) {
        if (!listaDeHQs.isEmpty()) {
            for (HQ h : listaDeHQs) {
                if (h.equals(hq)) {
                    return h;
                }
            }
        }
        return null;
    }

    @Override
    public void serializar() {
        try {
            ser.serializar(PATH, listaDeHQs);
        } catch (IOException ex) {
            Logger.getLogger(HqDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            if (o != null) {
                listaDeHQs = (LinkedList<HQ>) o;
            }
        } catch (IOException ex) {
            Logger.getLogger(HqDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HqDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
