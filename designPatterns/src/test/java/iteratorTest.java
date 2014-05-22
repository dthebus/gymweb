/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dthebus.designpatterns.behavioral.iterator.Item;
import com.dthebus.designpatterns.behavioral.iterator.Menu;
import java.util.Iterator;
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
public class iteratorTest {
    
    public iteratorTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     Item i1 = new Item("spaghetti", 7.50f);
     Item i2 = new Item("hamburger", 6.00f);
     Item i3 = new Item("chicken", 6.50f);
     
     Menu menu = new Menu();
     menu.addItem(i1);
     menu.addItem(i2);
     menu.addItem(i3);
     
     Iterator<Item> iterator = menu.iterator();
        
        
         Item item = iterator.next();
        // assertEquals(item, "spaghetti:R7.5");
         item = iterator.next();
        // assertEquals(item, "hamburger:R6.0");
     
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
