
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.edu.uepb.personalcollections.Game;
import br.edu.uepb.personalcollections.HQ;
import br.edu.uepb.personalcollections.Item;
import br.edu.uepb.personalcollections.Midia;
import br.edu.uepb.personalcollections.Tabuleiro;
import br.edu.uepb.personalcollections.enums.Console;
import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.TipoItem;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author faels_000
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)/
public class TestGerenciador {

    private Gerenciador manager;
    private HQ hq;
    private Midia midia;
    private Game game;
    private Tabuleiro tabu;
    private List<Item> listaDeItens;

    @Before
    public void setUp() {
        manager = new Gerenciador();
        hq = new HQ("THE WALKING DEAD", "", "15/04/2015", 5.90, 0, 10, Estado.NOVO, false, TipoItem.HQ, 36, "HQM Editora", "", "", false);
        midia = new Midia("Blu-Ray - Busca Implacável 3", "Versão Estendida", "10/04/2015", 69.00, 1, 7.5, Estado.NOVO, true, "", "", true);
        game = new Game("FIFA 15", "", "01/01/2015", 69.90, 0, 10, Estado.NOVO, false, Console.PC, true);
        tabu = new Tabuleiro("As lendas de andor", "Andor precisa de vocês! O reino de Andor está em perigo.", "18/04/2015", 184.90, 1, 7.5, Estado.NOVO, false);
    }

    @Test
    public void testSave() {
        try {
            manager.inserirItem(hq);
            Assert.assertTrue(manager.listarHQs().size() == 1);
            Assert.assertFalse(manager.listarHQs().size() == 10);

            manager.inserirItem(midia);
            manager.inserirItem(game);
            manager.inserirItem(tabu);

            Assert.assertTrue(manager.listarItens().size() == 4);
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(TestGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testDelete() throws PersonalCollectionsException {
        inserir();
        Assert.assertTrue(manager.removerMidia(midia.getId()));
        Assert.assertFalse(manager.removerHQ(1010)); // HQ com id 1010 nao existe
    }

    public void inserir() {
        try {
            manager.inserirItem(hq);
            manager.inserirItem(midia);
            manager.inserirItem(game);
            manager.inserirItem(tabu);
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(TestGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
