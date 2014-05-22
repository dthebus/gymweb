/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dthebus.designpatterns.behavioral.memento.DietInfo;
import com.dthebus.designpatterns.behavioral.memento.DietInfoCaretaker;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author darren
 */
public class mementoTest {
    
    public mementoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     DietInfoCaretaker dietInfoCaretaker = new DietInfoCaretaker();
     
     DietInfo dietInfo = new DietInfo("Fred", 1, 100);
     dietInfo.setDayNumberAndWeight(2, 99);
     dietInfoCaretaker.saveState(dietInfo);
     dietInfo.setDayNumberAndWeight(3, 98);
     
     assertEquals(dietInfo.getWeight(), 98);
     dietInfo.setDayNumberAndWeight(4, 97);
     dietInfoCaretaker.restoreState(dietInfo);
     
      assertEquals(dietInfo.getWeight(), 99);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
