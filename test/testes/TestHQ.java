package testes;

import enums.Estado;
import enums.TipoItem;
import excecoes.PersonalCollectionsException;
import dao.HqDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tipos.HQ;

public class TestHQ {

    private List<HQ> listaDeHQs;
    private HQ hq1, hq2, hq3;
    private HqDAO gerenciadorHQ;
    private final TipoItem tipo = TipoItem.HQ;

    @Before
    public void criaHQs() {
        listaDeHQs = new ArrayList<>();
        gerenciadorHQ = new HqDAO();

        hq1 = new HQ("THE WALKING DEAD", "", "15/04/2015", 5.90, 0, 10, Estado.NOVO, false, tipo, 36, "HQM Editora", "", "", false);
        hq2 = new HQ("AVENTURAS DO SUPERMAN, AS", "", "09/01/2013", 10.0, 2, 9.5, Estado.RASURADO, true, tipo, 9, "Abril", "", "DC", true);
        hq3 = new HQ("CAVALEIRO DA LUA : RECOMEÇO", "", "11/05/2015", 18.90, 0, 8, Estado.NOVO, true, tipo, 1, "Marvel", "", "Marvel", false);
    }

    @Test
    public void testSalvar() {
        try {
            saves();
            listaDeHQs = gerenciadorHQ.listar();

            // verifica se o obejtos salvos é igual com os que foram salvos na lista nas posições corretas
            Assert.assertEquals(hq1, listaDeHQs.get(0));
            Assert.assertEquals(hq2, listaDeHQs.get(1));
            Assert.assertEquals(hq3, listaDeHQs.get(2));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testListar() {
        try {
            saves();

            listaDeHQs = gerenciadorHQ.listar();
            // Como foi add 3 itens é verificado se o listar estar retornando 3
            Assert.assertTrue(listaDeHQs.size() == 3);
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
            HQ hq4 = new HQ("NOVA Lua Variante", "", "", 10.0, 0, 10, Estado.NOVO, false, tipo, 16, "NovA", "Ilimitada", "Marvel", false);
            Assert.assertEquals(null, gerenciadorHQ.pesquisar(hq4)); // deverá retonar null pois o hq4 não existe na lista
            Assert.assertEquals(hq1, gerenciadorHQ.pesquisar(hq1)); // deverá retornar o objeto hq1, pois ele estar contido na lista

            /**
             * Pesquisa pelo título do item Retorna uma lista com todas as
             * ocorrencias da busca ou retorna uma lista vazia caso não encontra
             * nada
             */
            List<HQ> verif_encontrado = new ArrayList<>();
            gerenciadorHQ.save(hq4);

            verif_encontrado.add(hq3);
            verif_encontrado.add(hq4);
            Assert.assertEquals(verif_encontrado, gerenciadorHQ.pesquisar("lua"));
            Assert.assertEquals(0, gerenciadorHQ.pesquisar("Não existo, não me encontrarás e lista vazia retornarei!").size());
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
            HQ hq_ori = new HQ("ME ATUALIZE!", "", "", 10.0, 0, 10, Estado.NOVO, false, tipo, 16, "NovA", "Ilimitada", "", false);
            hq_ori.setId(120);
            gerenciadorHQ.save(hq_ori);

            HQ hq_update = new HQ("ITEM ATUALIZA!!!", "qualquer", "01/05/2004", 10.0, 20, 10, Estado.RASURADO, false, tipo, 16, "NovA", "Ilimitada", "NoVA", true);
            hq_update.setId(120);

            // Atualiza a hq_ori com a hq_update, pois tem o mesmo id
            gerenciadorHQ.atualizar(hq_update);
            Assert.assertTrue(hq_update.getTitulo() == gerenciadorHQ.pesquisar(hq_update).getTitulo());

            // Nao deve atualizar pois o bjeto a ser atualizado não existe na lista
            HQ nao_salvo = new HQ("NAO EXISTO!", "", "", 0.0, 0, 0, Estado.NOVO, false, tipo, 0, "", "", "", false);
            gerenciadorHQ.atualizar(nao_salvo);
            Assert.assertFalse(nao_salvo.equals(gerenciadorHQ.pesquisar(nao_salvo)));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testRemover() {
        try {
            saves();
            Assert.assertTrue(gerenciadorHQ.remove(hq2));
            Assert.assertFalse(gerenciadorHQ.remove(hq2)); // já foi removido, deverá retornar false
            Assert.assertFalse(!gerenciadorHQ.remove(hq1));
            Assert.assertTrue(gerenciadorHQ.remove(hq3));

            // Verifica se a lista estar realmente vazia, já que foi removido todos
            Assert.assertTrue(gerenciadorHQ.listar().isEmpty());
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testToString() {
//		System.out.println(hq1);

        /**
         * Aqui já testa todos os métodos acessores (get e set) da classe (HQ) e
         * da classe mãe (Item)
         */
        Assert.assertTrue(hq1.toString().equals("Id: " + hq1.getId()
                + "\nTítulo: THE WALKING DEAD"
                + "\nOBS.: "
                + "\nEstado: Novo"
                + "\nData da compra: 15/04/2015"
                + "\nPreço de Compra: 5.9"
                + "\nNota: 10.0"
                + "\nTotal de Empréstimos: 0"
                + "\nEstá emprestado? false"
                + "\nNúmero: 36"
                + "\nEditora: HQM Editora"
                + "\nSaga: "
                + "\nJá foi lido? false"));
    }

    @Test
    public void testEquals() {
        Assert.assertFalse(hq1.equals(null)); // O objeto hq1 é diferente de null 
        Assert.assertFalse(hq1.equals(hq2)); // O objeto hq1 é diferente de hq2 
        Assert.assertFalse(hq2.equals(hq3)); // O objeto hq2 é diferente de jt3 
        Assert.assertFalse(!hq1.equals(hq1)); // O objeto hq1 é igual de hq1 
        Assert.assertTrue(hq2.equals(hq2)); // O objeto hq2 é igual a hq2

        // O objeto criado é diferente de hq1, pois apesar de nomes iguais eles tem ids diferentes
        Assert.assertTrue(!(new HQ("THE WALKING DEAD", "", "", 0.0, 0, 0, Estado.NOVO, false, tipo, 0, "", "", "", false).equals(hq1)));
    }

    private void saves() {
        try {
            gerenciadorHQ.save(hq1);
            gerenciadorHQ.save(hq2);
            gerenciadorHQ.save(hq3);
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }
}
