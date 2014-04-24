/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.EnergyDrink;
import com.dthebus.gymweb.repository.EnergyDrinkRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
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
public class EnergyDrinkTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static EnergyDrinkRepository repo;
    public EnergyDrinkTest() {
    }

      @Test
      public void createEnergyDrink() {
         repo = ctx.getBean(EnergyDrinkRepository.class);
         EnergyDrink p = new EnergyDrink.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createEnergyDrink")
     public void readEnergyDrink(){
         repo = ctx.getBean(EnergyDrinkRepository.class);
         EnergyDrink entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readEnergyDrink")
     private void updateEnergyDrink(){
         repo = ctx.getBean(EnergyDrinkRepository.class);
         EnergyDrink entity = repo.findOne(id);
         EnergyDrink updatedentity = new EnergyDrink.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         EnergyDrink updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateEnergyDrink")
     private void deleteEnergyDrink(){
         repo = ctx.getBean(EnergyDrinkRepository.class);
         EnergyDrink person = repo.findOne(id);
         repo.delete(person);
         EnergyDrink deletedPerson = repo.findOne(id);
         Assert.assertNull(deletedPerson);
         }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
