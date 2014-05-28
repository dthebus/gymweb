/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.shop.Supplement;
import com.dthebus.gymweb.repository.SupplementRepository;
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
public class SupplementTest {
     public static ApplicationContext ctx;
    private Long id;

    private static SupplementRepository repo;
    public SupplementTest() {
    }

      @Test
      public void createSupplement() {
         repo = ctx.getBean(SupplementRepository.class);
         Supplement p = new Supplement.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createSupplement")
     public void readSupplement(){
         repo = ctx.getBean(SupplementRepository.class);
         Supplement entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readSupplement")
     private void updateSupplement(){
         repo = ctx.getBean(SupplementRepository.class);
         Supplement entity = repo.findOne(id);
         Supplement updatedentity = new Supplement.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Supplement updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateSupplement")
     private void deleteSupplement(){
         repo = ctx.getBean(SupplementRepository.class);
         Supplement person = repo.findOne(id);
         repo.delete(person);
         Supplement deletedPerson = repo.findOne(id);
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
