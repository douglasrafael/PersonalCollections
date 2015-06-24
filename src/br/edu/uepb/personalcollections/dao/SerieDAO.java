package br.edu.uepb.personalcollections.dao;

import java.util.LinkedList;
import java.util.List;

import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.Serie;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contém as implementações de: (listar, buscar, inserir, atualizar, deletar, serializar, deserializar...) referente ao tipo Serie 
 * 
 * @author Douglas Rafael
 */
public class SerieDAO implements DAO<Serie> {

    private static List<Serie> listaDeSeries = new LinkedList<>();
    private Serializador ser;
    private final String PATH = "data/data_serie.dat";

    /**
     * Construtor. Cria a instância do Serializador
     */
    public SerieDAO() {
        this.ser = new Serializador();
    }

    @Override
    public List<Serie> listar() throws PersonalCollectionsException {
        if (listaDeSeries.isEmpty()) {
            deserializar();
        }
        return listaDeSeries;
    }

    @Override
    public void save(Serie s) throws PersonalCollectionsException {
        listaDeSeries.add(s);
        serializar();
    }

    @Override
    public void atualizar(Serie s) throws PersonalCollectionsException {
        if (!listaDeSeries.isEmpty()) {
            Serie serie = pesquisar(s.getId());
            if (serie != null) {
                listaDeSeries.set(listaDeSeries.indexOf(serie), s);
                serializar();
            }
        }
    }

    @Override
    public boolean remove(Serie o) throws PersonalCollectionsException {
        boolean result = listaDeSeries.remove(o);
        if (result) {
            serializar();
        }
        return result;
    }

    /**
     * Procura Serie pelo título. Caso não seja encontrado nenhuma serie, a lista
     * é retornada vazia. Método útil quando se quer listar todas os series que
     * tem nome igual ou parecido, mais que são diferentes
     *
     * @param titulo O titulo da serie a ser procurado
     * @return Lista com Series encontradas
     */
    public List<Serie> pesquisar(String titulo) {
        List<Serie> seriesEncontrados = new LinkedList<>();
        if (!listaDeSeries.isEmpty()) {
            for (Serie s : listaDeSeries) {
                /**
                 * Verifica se o titulo da Serie estar contido no serie da vez Se
                 * estiver contido o serie é adicionada na lista de series encontradas
                 */
                if (s.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                    seriesEncontrados.add(s);
                }
            }
        }
        return seriesEncontrados;
    }

    /**
     * Procura por Serie utilizando o id. Caso não seja encontrado o serie, é
     * retornado null.
     *
     * @param id O id do Serie a ser procurada
     * @return O objeto Serie encontrado ou null caso não seja
     */
    @Override
    public Serie pesquisar(int id) {
        if (!listaDeSeries.isEmpty()) {
            for (Serie s : listaDeSeries) {
                if (s.getId() == id) {
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public void serializar() {
        try {
            ser.serializar(PATH, listaDeSeries);
        } catch (IOException ex) {
            Logger.getLogger(SerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deserializar() {
        try {
            Object o = ser.deserializar(PATH);
            if (o != null) {
                listaDeSeries = (LinkedList<Serie>) o;
            }
        } catch (IOException ex) {
            Logger.getLogger(SerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
