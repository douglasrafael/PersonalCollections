/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.EmprestimoDAO;
import enums.Estado;
import enums.Parentesco;
import enums.TipoItem;
import excecoes.PersonalCollectionsException;
import gerenciador.Gerenciador;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tipos.Amigo;
import tipos.Emprestimo;
import tipos.HQ;
import tipos.Item;

/**
 *
 * @author faels_000
 */
public class TestEmprestimo {

    private EmprestimoDAO empDAO;

    public TestEmprestimo() {
        empDAO = new EmprestimoDAO();
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testaInsert() {
        try {
            Object o = new HQ(1, "test", null, null, 0, 1, 1, Estado.NOVO, true, TipoItem.HQ, 1, "", "", "", true);
            Item i = (Item) o;
            Gerenciador g = new Gerenciador();
            g.inserirEmprestimo(new Emprestimo("12/11/2014", "12/12/2014", new Amigo(1, "Do", 'M', null, null, null, Parentesco.PAI), i));
            Assert.assertTrue(empDAO.listar().size() == 1);
            System.out.println(empDAO.listar());
        } catch (PersonalCollectionsException ex) {
            Logger.getLogger(TestEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
