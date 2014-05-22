/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dthebus.designpatterns.structural.flyweight.Flyweight;
import com.dthebus.designpatterns.structural.flyweight.FlyweightFactory;
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
public class flyweightTest {
    
    public flyweightTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void flyweighttest() {
     FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();
     Flyweight flyweightAdder = flyweightFactory.getFlyweight("add");
     Flyweight flyweightmult = flyweightFactory.getFlyweight("multiply");
         assertEquals(flyweightAdder.doMath(2, 3), 5);
         assertEquals(flyweightmult.doMath(2, 3), 6);
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
