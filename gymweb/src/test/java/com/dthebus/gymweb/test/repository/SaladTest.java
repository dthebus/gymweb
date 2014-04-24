/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Salad;
import com.dthebus.gymweb.repository.SaladRepository;
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
public class SaladTest {
    
     public static ApplicationContext ctx;
    private Long id;

    private static SaladRepository repo;
    public SaladTest() {
    }

      @Test
      public void createSalad() {
         repo = ctx.getBean(SaladRepository.class);
         Salad p = new Salad.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createSalad")
     public void readSalad(){
         repo = ctx.getBean(SaladRepository.class);
         Salad entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readSalad")
     private void updateSalad(){
         repo = ctx.getBean(SaladRepository.class);
         Salad entity = repo.findOne(id);
         Salad updatedentity = new Salad.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Salad updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateSalad")
     private void deleteSalad(){
         repo = ctx.getBean(SaladRepository.class);
         Salad person = repo.findOne(id);
         repo.delete(person);
         Salad deletedPerson = repo.findOne(id);
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
