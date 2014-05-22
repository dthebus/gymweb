/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dthebus.designpatterns.behavioral.chainofresponsibility.EarthHandler;
import com.dthebus.designpatterns.behavioral.chainofresponsibility.MercuryHandler;
import com.dthebus.designpatterns.behavioral.chainofresponsibility.PlanetEnum;
import com.dthebus.designpatterns.behavioral.chainofresponsibility.PlanetHandler;
import com.dthebus.designpatterns.behavioral.chainofresponsibility.VenusHandler;
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
public class chainOfResponsibilityTest {
    
    public chainOfResponsibilityTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         PlanetHandler chain = setUpChain();
         assertEquals(chain.handleRequest(PlanetEnum.VENUS), "venus");
         //chain.handleRequest(PlanetEnum.MERCURY);
        // chain.handleRequest(PlanetEnum.EARTH);
         
         
         
     }
    public static PlanetHandler setUpChain()
         {
             PlanetHandler mercuryHandler = new MercuryHandler();
              PlanetHandler venusHandler = new VenusHandler();
               PlanetHandler earthHandler = new EarthHandler();
               mercuryHandler.setSuccessor(venusHandler);
               venusHandler.setSuccessor(earthHandler);
              return mercuryHandler;   
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
