/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dthebus.designpatterns.structural.composite.Composite;
import com.dthebus.designpatterns.structural.composite.Leaf;
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
public class compositTest {
    
    public compositTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     Leaf l1 = new Leaf("Bob");
     Leaf l2 = new Leaf("Fred");
     Leaf l3 = new Leaf("Sue");
     Leaf l4 = new Leaf("Ellen");
     Leaf l5 = new Leaf("Joe");
     
     Composite composite1 = new Composite();
     composite1.add(l1);
     composite1.add(l2);
     
     Composite composite2 = new Composite();
     composite2.add(l3);
     composite2.add(l4);
     
     Composite composite3 = new Composite();
     composite3.add(composite1);
     composite3.add(composite2);
     composite3.add(l5);
     
     assertEquals(l1.sayHello(), "Hello Bob");
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
