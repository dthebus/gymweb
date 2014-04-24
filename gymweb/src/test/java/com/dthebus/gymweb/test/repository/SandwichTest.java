/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Sandwich;
import com.dthebus.gymweb.repository.SandwichRepository;
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
public class SandwichTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static SandwichRepository repo;
    public SandwichTest() {
    }

      @Test
      public void createSandwich() {
         repo = ctx.getBean(SandwichRepository.class);
         Sandwich p = new Sandwich.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createSandwich")
     public void readSandwich(){
         repo = ctx.getBean(SandwichRepository.class);
         Sandwich entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readSandwich")
     private void updateSandwich(){
         repo = ctx.getBean(SandwichRepository.class);
         Sandwich entity = repo.findOne(id);
         Sandwich updatedentity = new Sandwich.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Sandwich updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateSandwich")
     private void deleteSandwich(){
         repo = ctx.getBean(SandwichRepository.class);
         Sandwich person = repo.findOne(id);
         repo.delete(person);
         Sandwich deletedPerson = repo.findOne(id);
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
