/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dthebus.designpatterns.structural.adapter.TemperatureClassReporter;
import com.dthebus.designpatterns.structural.adapter.TemperatureInfo;
import com.dthebus.designpatterns.structural.adapter.TemperatureObjectReporter;
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
public class adapterTest {
    
    public adapterTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void adapTest() {
     
     TemperatureInfo tempInfo = new TemperatureClassReporter();
     tempInfo.setTemperatureInC(10);
         assertEquals(tempInfo.getTemperatureInC(), 10.0);
         assertEquals(tempInfo.getTemperatureInF(), 50.0);
         
         tempInfo = new TemperatureObjectReporter();
         tempInfo.setTemperatureInf(85);
         assertEquals(tempInfo.getTemperatureInC(), 29.444444444444443);
         assertEquals(tempInfo.getTemperatureInF(), 85.0);
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
