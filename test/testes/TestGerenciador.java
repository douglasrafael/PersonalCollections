
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.edu.uepb.personalcollections.DLC;
import br.edu.uepb.personalcollections.Game;
import br.edu.uepb.personalcollections.HQ;
import br.edu.uepb.personalcollections.Item;
import br.edu.uepb.personalcollections.Midia;
import br.edu.uepb.personalcollections.Tabuleiro;
import br.edu.uepb.personalcollections.enums.Console;
import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.FiltroItem;
import br.edu.uepb.personalcollections.enums.LocalizacaoDLC;
import br.edu.uepb.personalcollections.enums.TipoItem;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import java.util.ArrayList;
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
        hq = new HQ("THE WALKING DEAD", "", "15/04/2015", 5.90, 0, 10, Estado.NOVO, false, TipoItem.HQ, 36, "HQM Editora", "Sem fim", "Alguma coisa", false);
        midia = new Midia("Blu-Ray - Busca Implacável 3", "Versão Estendida", "10/04/2015", 69.00, 1, 7.5, Estado.NOVO, true, "", "", true);
        List<DLC> dlc = new ArrayList<>();
        dlc.add(new DLC("Expansões de Times", LocalizacaoDLC.ORIGIN));
        game = new Game("FIFA 15", "", "01/01/2015", 69.90, 0, 10, Estado.DESGATADO, false, Console.PC, true, true, dlc);
        tabu = new Tabuleiro("As lendas de andor", "Andor precisa de vocês! O reino de Andor está em perigo.", "18/04/2015", 184.90, 1, 7.5, Estado.DEFEITUOSO, false);
    }

    @Test
    public void testBuscaComFiltro() {
        try {
            inserir();
            manager.listarItens();

            // HQ
            List<Item> item = manager.pesquisarItem(FiltroItem.TITULO, "NAO EXISTE ISSO");
            Assert.assertTrue(item.isEmpty());

            HQ h0 = (HQ) manager.pesquisarItem(FiltroItem.TITULO, "WALKING").get(0);
            Assert.assertEquals(h0, hq);

            HQ h2 = (HQ) manager.pesquisarItem(FiltroItem.HQEDITORA, "HQM ed").get(0);
            Assert.assertEquals(h2, hq);

            HQ h3 = (HQ) manager.pesquisarItem(FiltroItem.HQESTADO, "nOvO").get(0);
            Assert.assertEquals(h3, hq);

            HQ h4 = (HQ) manager.pesquisarItem(FiltroItem.HQUNIVERSO, "coisa").get(0);
            Assert.assertEquals(h4, hq);

            // Midia
            Midia m0 = (Midia) manager.pesquisarItem(FiltroItem.TITULO, "Implacável").get(0);
            Assert.assertEquals(m0, midia);

            Midia m1 = (Midia) manager.pesquisarItem(FiltroItem.MIDIAESTADO, "NOVO").get(0);
            Assert.assertEquals(m1, midia);

            // Jogo de videogame
            Game g0 = (Game) manager.pesquisarItem(FiltroItem.GAMETITULO, "fifa 15").get(0);
            Assert.assertEquals(g0, game);

            Game g1 = (Game) manager.pesquisarItem(FiltroItem.GAMEESTADO, "desgat").get(0);
            Assert.assertEquals(g1, game);

            Game g3 = (Game) manager.pesquisarItem(FiltroItem.GAMEDLC, "times").get(0);
            Assert.assertEquals(g3, game);

            // Jogo de tabuleiro
            Tabuleiro t0 = (Tabuleiro) manager.pesquisarItem(FiltroItem.TABULEIROTITULO, "andor").get(0);
            Assert.assertEquals(t0, tabu);

            Tabuleiro t1 = (Tabuleiro) manager.pesquisarItem(FiltroItem.TABULEIROESTADO, "defeit").get(0);
            Assert.assertEquals(t1, tabu);

        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(TestGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void limpaListaDeItems() {
        try {
            inserir();
            Assert.assertTrue(manager.listarItens().size() > 0);
            
            // Limpando lista de items
            manager.cleanItems();
            System.out.println(""+ manager.listarItens());
            Assert.assertTrue(manager.listarItens().isEmpty());
            
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(TestGerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    @Test
//    public void testSave() {
//        try {
//            manager.inserirItem(hq);
//            Assert.assertTrue(manager.listarHQs().size() == 1);
//            Assert.assertFalse(manager.listarHQs().size() == 10);
//
//            manager.inserirItem(midia);
//            manager.inserirItem(game);
//            manager.inserirItem(tabu);
//
//            Assert.assertTrue(manager.listarItens().size() == 4);
//        } catch (PersonalCollectionsException ex) {
//            Logger.getLogger(TestGerenciador.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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
