/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.edu.uepb.personalcollections.util.MyData;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;

/**
 *
 * @author Douglas
 */
public class TestMyData {

    @Before
    public void setUp() {

    }

    @Test
    public void testStringToCalendar() {
        try {
            if (!(MyData.stringToCalendar("16/05/2014") instanceof Calendar)) {
                fail();
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestMyData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testCalendarToString() {
        Calendar h = new GregorianCalendar();
        Assert.assertTrue("24/06/2015".equals(MyData.calendarToString(h)));
        Assert.assertFalse("123/06/2015".equals(MyData.calendarToString(h)));
        Assert.assertFalse("123--06/2015".equals(MyData.calendarToString(h)));
    }
    
    @Test
    public void testDiferencaDias() {
        try {
            Calendar dataInicial = MyData.stringToCalendar("06/06/2015");
            Calendar dataFinal = MyData.stringToCalendar("07/06/2014");
            Assert.assertEquals(-364, MyData.diferencaDias(dataInicial, dataFinal));
            
            dataInicial = MyData.stringToCalendar("06/06/2015");
            dataFinal = MyData.stringToCalendar("24/06/2015");
            Assert.assertEquals(18, MyData.diferencaDias(dataInicial, dataFinal));
        } catch (ParseException ex) {
            Logger.getLogger(TestMyData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
