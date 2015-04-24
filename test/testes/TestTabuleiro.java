package testes;

import enums.Estado;
import enums.TipoItem;
import excecoes.PersonalCollectionsException;
import gerenciador.GerenciadorTabuleiro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tipos.Tabuleiro;

public class TestTabuleiro {

    private List<Tabuleiro> listaJogosTabuleiro;
    private Tabuleiro jt1, jt2, jt3;
    private GerenciadorTabuleiro gt;
    private final TipoItem tipo = TipoItem.JOGOTABULEIRO;

    @Before
    public void criaJogosTabuleiro() {
        listaJogosTabuleiro = new ArrayList<>();
        gt = new GerenciadorTabuleiro();
        jt1 = new Tabuleiro("As lendas de andor", "Andor precisa de vocês! O reino de Andor está em perigo.",
                "18/04/2015", 184.90, 1, 7.5, Estado.NOVO, false, tipo);
        jt2 = new Tabuleiro("War", "Edição Especial", "12/05/2012", 110.90, 0, 10.0, Estado.NOVO, true, tipo);
        jt3 = new Tabuleiro("Super Banco Imobiliário", "utiliza cartão de crédito em vez de notas de dinheiro. "
                + "O jogo vem com uma máquina eletrônica de crédito e débito.",
                "12/11/2013", 159.90, 2, 8.0, Estado.RASURADO, false, tipo);
    }

    @Test
    public void testSalvar() {
        try {
            saves();
            listaJogosTabuleiro = gt.listar();

            // verifica se o obejtos salvos é igual com os que foram salvos na lista nas posições corretas
            Assert.assertEquals(jt1, listaJogosTabuleiro.get(0));
            Assert.assertEquals(jt2, listaJogosTabuleiro.get(1));
            Assert.assertEquals(jt3, listaJogosTabuleiro.get(2));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testListar() {
        try {
            saves();
            gt.save(new Tabuleiro("Baralho", "Nada a declarar", "20/05/2002", 10.0, 15, 10.0, Estado.DESGATADO, true, tipo));
//			System.out.println("TOTAL ITEMS: " + gt.listar().size());

            // Como foi add 4 objetos, verifica se o método listar() estar retornando uma lista com 4 elementos
            Assert.assertTrue(gt.listar().size() == 4);
            Assert.assertFalse(gt.listar().size() != 4);
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
            Tabuleiro jt4 = new Tabuleiro("Buscareis e Não Me Encontrarás", "",
                    "", 0.0, 0, 0, Estado.QUEBRADO, false, tipo);
            Assert.assertEquals(null, gt.pesquisar(jt4));
            Assert.assertEquals(jt2, gt.pesquisar(jt2));

            /**
             * Pesquisa pelo título do item Retorna uma lista com todas as
             * ocorrencias da busca ou retorna uma lista vazia caso não encontra
             * nada
             */
            List<Tabuleiro> verif_encontrado = new ArrayList<Tabuleiro>();
            Tabuleiro jt5 = new Tabuleiro("Andor e suas aventuras", "nada a declarar",
                    "10/12/2014", 90.0, 0, 5, Estado.NOVO, false, tipo);
            gt.save(jt5);

            verif_encontrado.add(jt1);
            verif_encontrado.add(jt5);
            Assert.assertEquals(verif_encontrado, gt.pesquisar("andor"));
            Assert.assertEquals(0, gt.pesquisar("Não existo").size());
        } catch (PersonalCollectionsException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testAtualizar() {
        try {
            saves();
            Tabuleiro jt_original = new Tabuleiro("Devo ser Atualizado", "Alguma coisa", "02/01/2014", 10.90, 0, 2.5, Estado.QUEBRADO, false, tipo);
            jt_original.setId(20);
            Tabuleiro jt_atualizado = new Tabuleiro("FUI ATUALIZADO", "atualiza..", "15/02/2015", 11.90, 1, 5.0, Estado.NOVO, true, tipo);
            jt_atualizado.setId(20);
            gt.save(jt_original);

            gt.atualizar(jt_atualizado);
            Assert.assertTrue(jt_atualizado.equals(gt.pesquisar(jt_atualizado))); // vertica se a atualização foi suscedida

            Tabuleiro nao_salvo = new Tabuleiro("NAO EXISTO NA LISTA", "", "", 0, 0, 0, Estado.NOVO, false, tipo);
            gt.atualizar(nao_salvo); // Não atualiza pois o objeto não_salvo não foi salvo 
            Assert.assertFalse(nao_salvo.equals(gt.pesquisar(nao_salvo)));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testRemover() {
        try {
            saves();
            Assert.assertTrue(gt.remove(jt2));
            Assert.assertFalse(gt.remove(jt2));
            Assert.assertFalse(!gt.remove(jt1));
            Assert.assertTrue(gt.remove(jt3));

            // Verifica se a lista estar realmente vazia, já que foi removido todos
            Assert.assertTrue(gt.listar().isEmpty());
        } catch (PersonalCollectionsException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testToString() {
//		System.out.println(jt1);

        /**
         * Aqui já testa todos os métodos acessores (get e set) da classe
         * (Tabuleiro) e da classe mãe (Item)
         */
        Assert.assertTrue(jt1.toString().equals("Id: " + jt1.getId()
                + "\nTítulo: As lendas de andor"
                + "\nOBS.: Andor precisa de vocês! O reino de Andor está em perigo."
                + "\nEstado: Novo"
                + "\nData da compra: 18/04/2015"
                + "\nPreço de Compra: 184.9"
                + "\nNota: 7.5"
                + "\nTotal de Empréstimos: 1"
                + "\nEstá emprestado? false"));
    }

    @Test
    public void testEquals() {
        Assert.assertFalse(jt1.equals(null)); // O objeto jt1 é diferente de null 
        Assert.assertFalse(jt1.equals(jt2)); // O objeto jt1 é diferente de jt2 
        Assert.assertFalse(jt1.equals(jt3)); // O objeto jt1 é diferente de jt3 
        Assert.assertFalse(!jt1.equals(jt1)); // O objeto jt1 é igual de jt1 
        Assert.assertTrue(jt3.equals(jt3)); // O objeto jt3 é igual a jt3

        // O objeto criado é diferente de jt2, pois apesar de nomes iguais eles tem ids diferentes
        Assert.assertTrue(!(new Tabuleiro("War", "", "", 0.0, 0, 0, Estado.NOVO, true, tipo).equals(jt2)));
    }

    private void saves() {
        try {
            gt.save(jt1);
            gt.save(jt2);
            gt.save(jt3);
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }
}