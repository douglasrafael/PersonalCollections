/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.edu.uepb.personalcollections.dao.EmprestimoDAO;
import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.Parentesco;
import br.edu.uepb.personalcollections.enums.TipoItem;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.edu.uepb.personalcollections.Amigo;
import br.edu.uepb.personalcollections.Emprestimo;
import br.edu.uepb.personalcollections.HQ;
import br.edu.uepb.personalcollections.Item;

/**
 *
 * @author faels_000
 */
public class TestEmprestimo {

    private EmprestimoDAO empDAO;

    public TestEmprestimo() {
        
    }

    @Before
    public void setUp() {
        empDAO = new EmprestimoDAO();
    }

    @Test
    public void testInsert() {
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
