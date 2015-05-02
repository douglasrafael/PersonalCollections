package testes;

import enums.Parentesco;
import excecoes.PersonalCollectionsException;
import dao.AmigoDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tipos.Amigo;

public class TestAmigo {

    private List<Amigo> listaDeAmigos;
    private Amigo amigo1, amigo2, amigo3;
    private AmigoDAO gerenciadorAmigo;

    @Before
    public void criaAmigos() {
        listaDeAmigos = new ArrayList<>();
        gerenciadorAmigo = new AmigoDAO();

        amigo1 = new Amigo("José Marcos da Silva", 'F', "Rua João Cariri", "3335-0056", "joaomarcos@mail.com", Parentesco.CONHECIDO);
        amigo2 = new Amigo("Maria Aparecida Alcides", 'F', "Rua Chargas", "3321-5968", "aparecida_maria@mail.com", Parentesco.PRIMA);
        amigo3 = new Amigo("Silva", 'M', "Av. Paulista", "3341-2567", "silva@outlook.com", Parentesco.PRIMO);
    }

    @Test
    public void testSalvar() {
        try {
            saves();
            listaDeAmigos = gerenciadorAmigo.listar();

            // verifica se o obejtos salvos é igual com os que foram salvos na lista nas posições corretas
            Assert.assertEquals(amigo1, listaDeAmigos.get(0));
            Assert.assertEquals(amigo2, listaDeAmigos.get(1));
            Assert.assertEquals(amigo3, listaDeAmigos.get(2));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }

    }

    @Test
    public void testListar() {
        try {
            saves();
            listaDeAmigos = gerenciadorAmigo.listar();
            // Como foi add 3 itens é verificado se o listar estar retornando 3
            Assert.assertTrue(listaDeAmigos.size() == 3);
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testPesquisar() {
        try {
            saves();
            /**
             * Pesquisa pelo objeto completo.
             */
            Amigo amigo4 = new Amigo("Aparecida dos Ramos", 'F', "", "", "", Parentesco.AVO1);
            Assert.assertEquals(null, gerenciadorAmigo.pesquisar(123)); // deverá retonar null pois não há amigo com id 123
            Assert.assertEquals(amigo1, gerenciadorAmigo.pesquisar(amigo1.getId())); // deverá retornar o objeto amigo1, pois ele estar contido na lista

            /**
             * Pesquisa pelo nome do amigo
             */
            List<Amigo> encontrados = new ArrayList<>();
            gerenciadorAmigo.save(amigo4);
            encontrados.add(amigo2);
            encontrados.add(amigo4);
            Assert.assertTrue(gerenciadorAmigo.pesquisar("José Marcos").size() == 1);
            Assert.assertEquals(0, gerenciadorAmigo.pesquisar("Amigo não existente!").size());
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testAtualizar() {
        /**
         * Os amigos são atualizados de acordo com os ids
         */
        try {
            saves();
            Amigo amigo_ori = new Amigo("Amigo a atualizar", 'M', "", "", "", Parentesco.PRIMO);
            amigo_ori.setId(99);
            gerenciadorAmigo.save(amigo_ori);

            Amigo amigo_update = new Amigo("Matias Pereira Souza", 'M', "Ru aalguma coisa", "33315-2515", "matias@mail.com", Parentesco.PRIMO);
            amigo_update.setId(99);

            // Atualiza o amigo_ori com a amigo_update, pois tem o mesmo id
            gerenciadorAmigo.atualizar(amigo_update);
            Assert.assertTrue(amigo_update.getNome() == gerenciadorAmigo.pesquisar(amigo_update.getId()).getNome());

            // Nao deve atualizar pois o objeto a ser atualizado não existe na lista
            Amigo nao_salvo = new Amigo("Amigo temp", 'M', "", "", "", null);
            gerenciadorAmigo.atualizar(nao_salvo);
            Assert.assertFalse(nao_salvo.equals(gerenciadorAmigo.pesquisar(nao_salvo.getId())));
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testRemover() {
        try {
            saves();
            Assert.assertTrue(gerenciadorAmigo.remove(amigo2));
            Assert.assertFalse(gerenciadorAmigo.remove(amigo2)); // já foi removido, deverá retornar false
            Assert.assertFalse(!gerenciadorAmigo.remove(amigo1));
            Assert.assertTrue(gerenciadorAmigo.remove(amigo3));

            // Verifica se a lista estar realmente vazia, já que foi removido todos
            Assert.assertTrue(gerenciadorAmigo.listar().isEmpty());
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testToString() {
//		System.out.println(amigo2);

        /**
         * Aqui já testa todos os métodos acessores (get e set) da classe
         * (Amigo) e da classe mãe (Pessoa)
         */
        Assert.assertTrue(amigo2.toString().equals("Id: " + amigo2.getId()
                + "\nNome: Maria Aparecida Alcides"
                + "\nSexo: F"
                + "\nEndereço: Rua Chargas"
                + "\nTelefone: 3321-5968"
                + "\nE-Mail: aparecida_maria@mail.com"
                + "\nParentesco: Prima"));

        Assert.assertFalse(amigo1.toString().equals(""));
    }

    private void saves() {
        try {
            gerenciadorAmigo.save(amigo1);
            gerenciadorAmigo.save(amigo2);
            gerenciadorAmigo.save(amigo3);
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }
}
