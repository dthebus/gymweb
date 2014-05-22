/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dthebus.designpatterns.structural.bridge.BigBus;
import com.dthebus.designpatterns.structural.bridge.BigEngine;
import com.dthebus.designpatterns.structural.bridge.SmallCar;
import com.dthebus.designpatterns.structural.bridge.SmallEngine;
import com.dthebus.designpatterns.structural.bridge.Vehicle;
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
public class bridgeTest {
    
    public bridgeTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void test() {
     
         Vehicle vehicle = new BigBus(new SmallEngine());
         assertEquals(vehicle.drive(), "slow");
     vehicle.setEngine(new BigEngine());
     assertEquals(vehicle.drive(), "slow");
      Vehicle vehicle1 = new SmallCar(new SmallEngine());
         assertEquals(vehicle1.drive(), "average");
     vehicle1.setEngine(new BigEngine());
     assertEquals(vehicle1.drive(), "fast");
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
