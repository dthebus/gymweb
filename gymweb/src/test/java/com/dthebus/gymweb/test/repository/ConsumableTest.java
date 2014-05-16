/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Consumable;
import com.dthebus.gymweb.repository.ConsumableRepository;
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
public class ConsumableTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static ConsumableRepository repo;
    public ConsumableTest() {
    }

      @Test
      public void createConsumable() {
         repo = ctx.getBean(ConsumableRepository.class);
         Consumable p = new Consumable.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createConsumable")
     public void readConsumable(){
         repo = ctx.getBean(ConsumableRepository.class);
         Consumable entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readConsumable")
     private void updateConsumable(){
         repo = ctx.getBean(ConsumableRepository.class);
         Consumable entity = repo.findOne(id);
         Consumable updatedentity = new Consumable.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Consumable updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateConsumable")
     private void deleteConsumable(){
         repo = ctx.getBean(ConsumableRepository.class);
         Consumable person = repo.findOne(id);
         repo.delete(person);
         Consumable deletedPerson = repo.findOne(id);
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
