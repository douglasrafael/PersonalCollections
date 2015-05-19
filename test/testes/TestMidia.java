package testes;

import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.TipoItem;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.dao.MidiaDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uepb.personalcollections.Midia;

public class TestMidia {

    private List<Midia> listaDeMidias;
    private Midia m1, m2, m3;
    private MidiaDAO gerenciadorMidia;

    @Before
    public void criaMidia() {
        listaDeMidias = new ArrayList<>();
        gerenciadorMidia = new MidiaDAO();

        m1 = new Midia("Game Of Thrones: A Quarta Temporada Completa", "", "10/01/2015", 149.90, 0, 10, Estado.NOVO, false, "HBO", "quarta temporada baseada nos livros best-sellers de George R.R. Martin", true);
        m2 = new Midia("Blu-Ray - Busca Implacável 3", "Versão Estendida", "10/04/2015", 69.00, 1, 7.5, Estado.NOVO, true, "", "", true);
        m3 = new Midia("Blu-Ray - Maze Runner: Correr ou Morrer", "", "07/01/2015", 79.90, 2, 10, Estado.DESGATADO, false, "", "Em um mundo pós-apocalíptico, o jovem Thomas (Dylan O'Brien) é abandonado em uma "
                + "comunidade isolada formada por garotos após toda sua memória ter sido apagada. Logo ele se vê preso em um labirinto, onde será preciso unir forças com outros jovens para que consiga escapar.", true);
    }

    @Test
    public void testSalvar() {
        try {
            saves();
            listaDeMidias = gerenciadorMidia.listar();

            // verifica se o obejtos salvos é igual com os que foram salvos na lista nas posições corretas
            Assert.assertEquals(m1, listaDeMidias.get(0));
            Assert.assertEquals(m2, listaDeMidias.get(1));
            Assert.assertEquals(m3, listaDeMidias.get(2));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }

    }

    @Test
    public void testListar() {
        try {
            saves();
            listaDeMidias = gerenciadorMidia.listar();
            // Como foi add 3 itens é verificado se o listar estar retornando 3
            Assert.assertTrue(listaDeMidias.size() == 3);
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
            Midia m4 = new Midia("Busca Implacável 4", "", "", 89.90, 0, 8, Estado.NOVO, false, "", "", false);
            Assert.assertEquals(null, gerenciadorMidia.pesquisar(m4)); // deverá retonar null pois o m4 não existe na lista
            Assert.assertEquals(m1, gerenciadorMidia.pesquisar(m1)); // deverá retornar o objeto m1, pois ele estar contido na lista

            /**
             * Pesquisa pelo título do item Retorna uma lista com todas as
             * ocorrencias da busca ou retorna uma lista vazia caso não encontra
             * nada
             */
            List<Midia> verif_encontrado = new ArrayList<>();
            gerenciadorMidia.save(m4);

            verif_encontrado.add(m2);
            verif_encontrado.add(m4);
            Assert.assertEquals(verif_encontrado, gerenciadorMidia.pesquisar("implacável"));
            Assert.assertEquals(0, gerenciadorMidia.pesquisar("Não existo!").size());
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
            Midia m_ori = new Midia("ME ATUALIZE!!!", "", "", 0, 0, 0, Estado.NOVO, false, "", "", false);
            m_ori.setId(290);
            gerenciadorMidia.save(m_ori);

            Midia m_update = new Midia("Mídia atualizada...", "19/04/2014", "alguma coisa", 15.90, 15, 10, Estado.NOVO, true, "", "", true);
            m_update.setId(290);

            // Atualiza a m_ori com a m_update, pois tem o mesmo id
            gerenciadorMidia.atualizar(m_update);
            Assert.assertTrue(m_update.getTitulo() == gerenciadorMidia.pesquisar(m_update).getTitulo());

            // Nao deve atualizar pois o objeto a ser atualizado não existe na lista
            Midia nao_salvo = new Midia("NAO Existo!!!", "", "", 0, 0, 0, Estado.NOVO, false, "", "", false);
            gerenciadorMidia.atualizar(nao_salvo);
            Assert.assertFalse(nao_salvo.equals(gerenciadorMidia.pesquisar(nao_salvo)));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testRemover() {
        try {
            saves();
            Assert.assertTrue(gerenciadorMidia.remove(m2));
            Assert.assertFalse(gerenciadorMidia.remove(m2)); // já foi removido, deverá retornar false
            Assert.assertFalse(!gerenciadorMidia.remove(m1));
            Assert.assertTrue(gerenciadorMidia.remove(m3));

            // Verifica se a lista estar realmente vazia, já que foi removido todos
            Assert.assertTrue(gerenciadorMidia.listar().isEmpty());
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testToString() {
//		System.out.println(m1);

        /**
         * Aqui já testa todos os métodos acessores (get e set) da classe
         * (Midia) e da classe mãe (Item)
         */
        Assert.assertTrue(m1.toString().equals("Id: " + m1.getId()
                + "\nTítulo: Game Of Thrones: A Quarta Temporada Completa"
                + "\nOBS.: "
                + "\nEstado: Novo"
                + "\nData da compra: 10/01/2015"
                + "\nPreço de Compra: 149.9"
                + "\nNota: 10.0"
                + "\nTotal de Empréstimos: 0"
                + "\nEstá emprestado? false"
                + "\nMarca: HBO"
                + "\nConteúdo: quarta temporada baseada nos livros best-sellers de George R.R. Martin"
                + "\nJá foi assistido? true"));
    }

    @Test
    public void testEquals() {
        Assert.assertFalse(m1.equals(null)); // O objeto hq1 é diferente de null 
        Assert.assertFalse(m1.equals(m2)); // O objeto hq1 é diferente de hq2 
        Assert.assertFalse(m2.equals(m3)); // O objeto hq2 é diferente de jt3 
        Assert.assertFalse(!m1.equals(m1)); // O objeto hq1 é igual de hq1 
        Assert.assertTrue(m2.equals(m2)); // O objeto hq2 é igual a hq2

        // O objeto criado é diferente de m1, pois apesar de nomes iguais eles tem ids diferentes
        Assert.assertTrue(!(new Midia("Game Of Thrones: A Quarta Temporada Completa", "", "", 0, 0, 0, Estado.NOVO, false, "", "", false).equals(m1)));
    }

    private void saves() {
        try {
            gerenciadorMidia.save(m1);
            gerenciadorMidia.save(m2);
            gerenciadorMidia.save(m3);
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }
}
