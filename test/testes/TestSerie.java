package testes;

import br.edu.uepb.personalcollections.Item;
import br.edu.uepb.personalcollections.Midia;
import br.edu.uepb.personalcollections.Serie;
import br.edu.uepb.personalcollections.Tabuleiro;
import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
public class TestSerie {

    Gerenciador manager;
    List<Item> listaDeItem;
    Item item1, item2;

    @Before
    public void setUp() {
        manager = new Gerenciador();
        listaDeItem = new ArrayList<>();
        item1 = new Tabuleiro("Damas", "", "", 12.0, 0, 10, Estado.NOVO, false);
        item2 = new Midia("Programas", "", "", 0, 0, 10, Estado.NOVO, false, "", "", true);
    }

    @Test
    public void testSalvar() {
        try {
            listaDeItem.add(item1);
            Serie serie = new Serie("Minha série", listaDeItem);
            manager.inserirSerie(serie);
            
            listaDeItem.clear();
            listaDeItem.add(item2);
            Serie serie2 = new Serie("Minha série 2", listaDeItem);
            manager.inserirSerie(serie2);
        } catch (PersonalCollectionsException ex) {
            System.err.println("Erro ao inserir: " + ex.getMessage());
        }
    }

    @Test
    public void testListar() {
        try {
            List<Serie> listaDeSerie = manager.listarSeries();
            System.out.println(""+listaDeSerie);
        } catch (PersonalCollectionsException ex) {
            System.err.println("Erro ao listar: " + ex.getMessage());
        }

    }
}
