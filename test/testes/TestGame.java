package testes;

import enums.Console;
import enums.Estado;
import enums.LocalizacaoDLC;
import enums.TipoItem;
import excecoes.PersonalCollectionsException;
import dao.GameDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tipos.DLC;
import tipos.Game;

public class TestGame {

    private List<Game> listaDeGames;
    private List<DLC> dlcs1, dlcs2;
    private Game g1, g2, g3;
    private GameDAO gerenciadorGame;

    @Before
    public void criaMidia() {
        listaDeGames = new ArrayList<>();
        gerenciadorGame = new GameDAO();

        g1 = new Game("FIFA 15", "", "01/01/2015", 69.90, 0, 10, Estado.NOVO, false, Console.PC, true);
        dlcs1 = new ArrayList<>();
        dlcs1.add(new DLC("Battlefield 4 China Rising", LocalizacaoDLC.ORIGIN));
        dlcs1.add(new DLC("Battlefield 4 Second Assault", LocalizacaoDLC.ORIGIN));
        dlcs1.add(new DLC("Battlefield 4 Naval Strike", LocalizacaoDLC.ORIGIN));
        dlcs1.add(new DLC("Battlefield 4 Dragon’s Teeth", LocalizacaoDLC.ORIGIN));
        dlcs1.add(new DLC("Battlefield 4 Final Stand", LocalizacaoDLC.ORIGIN));
        g2 = new Game("Battlefield 4", "", "07/10/2014", 120.0, 1, 9, Estado.NOVO, true, Console.PC, true, true, dlcs1);
        dlcs2 = new ArrayList<>();
        dlcs2.add(new DLC("Assassin’s Creed Unity Season Pass", LocalizacaoDLC.PSN));
        g3 = new Game("Assassin's Creed IV: Black Flag", "O novo jogo da aclamada franquia Assassin's Creed "
                + "tem agora como palco a fatídica Era Dourada da Pirataria. ", "15/12/2014", 160.90, 0, 9.5, Estado.NOVO, false, Console.PS4, true, true, dlcs2);
    }

    @Test
    public void testSalvar() {
        try {
            saves();
            listaDeGames = gerenciadorGame.listar();

            // verifica se o obejtos salvos é igual com os que foram salvos na lista nas posições corretas
            Assert.assertEquals(g1, listaDeGames.get(0));
            Assert.assertEquals(g2, listaDeGames.get(1));
            Assert.assertEquals(g3, listaDeGames.get(2));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }

    }

    @Test
    public void testListar() {
        try {
            saves();
            listaDeGames = gerenciadorGame.listar();

            // Como foi add 3 itens é verificado se o listar estar retornando 3
            Assert.assertTrue(listaDeGames.size() == 3);
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testPesquisar() {
        try {
            saves();
            /**
             * Pesquisa pelo objeto completo. É usando as regras do equals para
             * comparação entre os objetos Retorna apenas o objeto a ser buscado
             * caso seja encontrado
             */
            Assert.assertEquals(null, gerenciadorGame.pesquisar(new Game("Nao existo", "", "", 0, 0, 0, Estado.NOVO, false, Console.XBOX360, false))); // deverá retonar null pois o objeto não existe na lista
            Assert.assertEquals(g1, gerenciadorGame.pesquisar(g1)); // deverá retornar o objeto m1, pois ele estar contido na lista

            /**
             * Pesquisa pelo título do item Retorna uma lista com todas as
             * ocorrencias da busca ou retorna uma lista vazia caso não encontra
             * nada
             */
            List<Game> verif_encontrado = new ArrayList<>();
            Game g4 = new Game("FIFA 14", "", "12/11/2013", 90.0, 5, 10, Estado.DESGATADO, true, Console.PS3, true);
            gerenciadorGame.save(g4);

            verif_encontrado.add(g1);
            verif_encontrado.add(g4);
            // Verifica se os items retornado na lista são mesmo o g1 e g4
            Assert.assertEquals(verif_encontrado, gerenciadorGame.pesquisar("fifa"));
            Assert.assertEquals(0, gerenciadorGame.pesquisar("Não existo!").size());
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testAtualizar() {
        /**
         * Os itens são atualizados de acordo com os ids
         */
        try {
            saves();
            Game g_ori = new Game("Exito para ser atualizado", "", "", 0, 0, 0, Estado.NOVO, false, Console.XBOX360, false);
            g_ori.setId(153);
            gerenciadorGame.save(g_ori);

            Game g_update = new Game("Novo jogo - Update", "", "", 260.90, 10, 0, Estado.NOVO, false, Console.XBOX360, false);
            g_update.setId(153);

            // Atualiza a g_ori com a g_update, pois tem o mesmo id
            gerenciadorGame.atualizar(g_update);
            Assert.assertTrue(g_update.getTitulo() == gerenciadorGame.pesquisar(g_update).getTitulo());

            // Nao deve atualizar pois o objeto a ser atualizado não existe na lista
            Game nao_salvo = new Game("Não existo...", "", "", 0, 0, 0, Estado.NOVO, false, Console.XBOX360, false);
            gerenciadorGame.atualizar(nao_salvo);
            Assert.assertFalse(nao_salvo.equals(gerenciadorGame.pesquisar(nao_salvo)));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testRemover() {
        try {
            saves();
            Assert.assertTrue(gerenciadorGame.remove(g2));
            Assert.assertFalse(gerenciadorGame.remove(g2)); // já foi removido, deverá retornar false
            Assert.assertFalse(!gerenciadorGame.remove(g1));
            Assert.assertTrue(gerenciadorGame.remove(g3));

            // Verifica se a lista estar realmente vazia, já que foi removido todos
            Assert.assertTrue(gerenciadorGame.listar().isEmpty());
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testEquals() {
        Assert.assertFalse(g1.equals(null)); // O objeto g1 é diferente de null 
        Assert.assertFalse(g1.equals(g2)); // O objeto g1 é diferente de g2 
        Assert.assertFalse(g2.equals(g3)); // O objeto g2 é diferente de g3 
        Assert.assertFalse(!g1.equals(g1)); // O objeto g1 é igual de g1 
        Assert.assertTrue(g2.equals(g2)); // O objeto g2 é igual a g2

        // O objeto criado é diferente de g2, pois apesar de nomes iguais eles tem ids diferentes
        Assert.assertTrue(!(new Game("Battlefield 4", "", "07/10/2014", 120.0, 1, 9, Estado.NOVO, true, Console.PC, true, true, dlcs1).equals(g2)));
    }

    private void saves() {
        try {
            System.out.println(g1.toString());
            gerenciadorGame.save(g1);
            gerenciadorGame.save(g2);
            gerenciadorGame.save(g3);
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }
}
