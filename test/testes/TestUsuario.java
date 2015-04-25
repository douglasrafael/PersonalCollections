package testes;

import dao.UsuarioDAO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tipos.Usuario;

public class TestUsuario {

    private UsuarioDAO gerencidorUsuario;
    private Usuario user;

    @Before
    public void init() {
        gerencidorUsuario = new UsuarioDAO();
        user = new Usuario("Douglas Rafael", 'M', "Admin", "123456");
    }

    @Test
    public void testAutenticacao() {
        Assert.assertTrue(gerencidorUsuario.autentica("Admin", "123456") != null); // login válido
        Assert.assertTrue(gerencidorUsuario.autentica("user", "12") == null); // login inválido
    }

    @Test
    public void testEquals() {
        Usuario user_compare = new Usuario("Douglas Rafael", 'M', "Admin", "");
        System.out.println(user);
        Assert.assertFalse(user.equals(user_compare)); // sao diferentes pois possui ids diferentes

        user_compare.setId(user.getId());
        Assert.assertTrue(user.equals(user_compare)); // São iguais, pois possuí mesmo id
    }
}
