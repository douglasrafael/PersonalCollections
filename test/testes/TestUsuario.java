package testes;

import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uepb.personalcollections.Usuario;

public class TestUsuario {

    private Gerenciador manager;
    private Usuario user;
    private char[] pass_correct = {'1','2','3','4','5','6'};

    @Before
    public void init() {
        manager = new Gerenciador();
        user = new Usuario("Douglas Rafael", 'M', "admin", pass_correct);
    }
    
    @Test
    public void testAtualizar() {
        manager.atualizarUsuario(user);
    }
    
    @Test
    public void testEquals() {
        char[] pass = {'1','2'};
        Usuario user_compare = new Usuario("Douglas Rafael", 'M', "doug", pass);
        Assert.assertFalse(user.equals(user_compare)); // sao diferentes pois possui login e password diferentes

        user_compare.setLogin("admin");
        user_compare.setPassword(pass_correct);
        Assert.assertTrue(user.equals(user_compare)); 
    }

    @Test
    public void testAutenticacao() {
        try {
            Assert.assertFalse(user.equals(manager.autenticar("Admin", pass_correct))); // login inválido
            Assert.assertEquals(user, manager.autenticar("admin", pass_correct)); // login válido
            char[] pass = {'a','b','c','d'};
            Assert.assertTrue(manager.autenticar("user", pass) == null); // login inválido
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

}
