/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.accounts.Fees;
import com.dthebus.gymweb.repository.FeesRepository;
import com.dthebus.gymweb.test.ConnectionConfigTest;
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
public class FeesTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static FeesRepository repo;
    public FeesTest() {
    }

      @Test
      public void createFees() {
         repo = ctx.getBean(FeesRepository.class);
         Fees p = new Fees.Builder("Monthly").price(250.00).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
   @Test(dependsOnMethods = "createFees")
     public void readFees(){
         repo = ctx.getBean(FeesRepository.class);
         Fees entity = repo.findOne(id);
         Assert.assertEquals(entity.getType(), "Monthly");
      }
     
    @Test(dependsOnMethods = "readFees")
     private void updateFees(){
         repo = ctx.getBean(FeesRepository.class);
         Fees entity = repo.findOne(id);
         Fees updatedentity = new Fees.Builder("Monthly").entity(entity).price(255.00).build();
         repo.save(updatedentity);
         Fees updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 255.00);
     }
     
     @Test(dependsOnMethods = "updateFees")
     private void deleteFees(){
         repo = ctx.getBean(FeesRepository.class);
         Fees person = repo.findOne(id);
         repo.delete(person);
         Fees deletedPerson = repo.findOne(id);
         Assert.assertNull(deletedPerson);
         }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
