package br.edu.uepb.personalcollections.dao;

import java.util.LinkedList;
import java.util.List;

import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.ListaDeDesejo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contém as implementações de: (listar, buscar, inserir, atualizar, deletar,
 * serializar, deserializar...) referente ao tipo ListaDeDesejo
 *
 * @author Douglas Rafael
 */
public class ListaDeDesejoDAO implements DAO<ListaDeDesejo> {
    
    private static List<ListaDeDesejo> listaDeDeDesejos = new LinkedList<>();
    private Serializador ser;
    private final String PATH = "data/data_listaDeDesejo.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public ListaDeDesejoDAO() {
        this.ser = new Serializador();
    }
    
    @Override
    public List<ListaDeDesejo> listar() throws PersonalCollectionsException {
        if (listaDeDeDesejos.isEmpty()) {
            deserializar();
        }
        return listaDeDeDesejos;
    }
    
    @Override
    public void save(ListaDeDesejo o) throws PersonalCollectionsException {
        listaDeDeDesejos.add(o);
        serializar();
    }
    
    @Override
    public void atualizar(ListaDeDesejo o) throws PersonalCollectionsException {
        if (!listaDeDeDesejos.isEmpty()) {
            ListaDeDesejo serie = pesquisar(o.getItem().getId());
            if (serie != null) {
                listaDeDeDesejos.set(listaDeDeDesejos.indexOf(serie), o);
                serializar();
            }
        }
    }
    
    @Override
    public boolean remove(ListaDeDesejo o) throws PersonalCollectionsException {
        boolean result = listaDeDeDesejos.remove(o);
        if (result) {
            serializar();
        }
        return result;
    }

    /**
     * Procura por ListaDeDesejo utilizando o id. Caso não seja encontrado, é
     * retornado null.
     *
     * @param id O id do item a ser procurada na lista de desejo
     * @return O objeto ListaDeDesejo encontrado ou null caso não seja
     */
    @Override
    public ListaDeDesejo pesquisar(int id) {
        if (!listaDeDeDesejos.isEmpty()) {
            for (ListaDeDesejo o : listaDeDeDesejos) {
                if (o.getItem().getId() == id) {
                    return o;
                }
            }
        }
        return null;
    }

    /**
     * Procura por Item na lista de desejo utilizando o título. Caso não seja encontrado, é
     * retornado null.
     *
     * @param titulo O título do item a ser procurada na lista de desejo
     * @return O objeto Item encontrado ou null caso não seja
     */
    public ListaDeDesejo pesquisar(String titulo) {
        if (!listaDeDeDesejos.isEmpty()) {
            for (ListaDeDesejo o : listaDeDeDesejos) {
                if (o.getItem().getTitulo().equals(titulo)) {
                    return o;
                }
            }
        }
        return null;
    }
    
    @Override
    public void serializar() {
        try {
            ser.serializar(PATH, listaDeDeDesejos);
        } catch (IOException ex) {
            Logger.getLogger(ListaDeDesejoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            if (o != null) {
                listaDeDeDesejos = (LinkedList<ListaDeDesejo>) o;
            }
        } catch (IOException ex) {
            Logger.getLogger(ListaDeDesejoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaDeDesejoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
