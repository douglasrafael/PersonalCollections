package testes;

import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.uepb.personalcollections.Usuario;

public class TestUsuario {

    private Gerenciador gerencidorUsuario;
    private Usuario user;

    @Before
    public void init() {
        gerencidorUsuario = new Gerenciador();
        user = new Usuario("Douglas Rafael", 'M', "Admin", "123456");
    }
    
    @Test
    public void testEquals() {
        Usuario user_compare = new Usuario("Douglas Rafael", 'M', "doug", "12");
        Assert.assertFalse(user.equals(user_compare)); // sao diferentes pois possui login e password diferentes

        user_compare.setLogin("Admin");
        user_compare.setPassword("123456");
        Assert.assertTrue(user.equals(user_compare)); 
    }

    @Test
    public void testAutenticacao() {
        try {
            Assert.assertTrue(user.equals(gerencidorUsuario.autenticar("Admin", "123456"))); // login válido
            Assert.assertTrue(gerencidorUsuario.autenticar("user", "12") == null); // login inválido
        } catch (PersonalCollectionsException e) {
            System.err.println(e.getMessage());
        }
    }

}
