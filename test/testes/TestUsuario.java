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

    @Before
    public void init() {
        manager = new Gerenciador();
        user = new Usuario("Douglas Rafael", 'M', "admin", "123456");
    }
    
    @Test
    public void testAtualizar() {
        manager.atualizarUsuario(user);
    }
    
    @Test
    public void testEquals() {
        Usuario user_compare = new Usuario("Douglas Rafael", 'M', "doug", "12");
        Assert.assertFalse(user.equals(user_compare)); // sao diferentes pois possui login e password diferentes

        user_compare.setLogin("admin");
        user_compare.setPassword("123456");
        Assert.assertTrue(user.equals(user_compare)); 
    }

    @Test
    public void testAutenticacao() {
        try {
            Assert.assertFalse(user.equals(manager.autenticar("Admin", "123456"))); // login inválido
            Assert.assertEquals(user, manager.autenticar("admin", "123456")); // login válido
            Assert.assertTrue(manager.autenticar("user", "12") == null); // login inválido
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

}
