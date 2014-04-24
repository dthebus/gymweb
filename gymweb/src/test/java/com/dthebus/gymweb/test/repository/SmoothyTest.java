/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Smoothy;
import com.dthebus.gymweb.repository.SmoothyRepository;
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
public class SmoothyTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static SmoothyRepository repo;
    public SmoothyTest() {
    }

      @Test
      public void createSmoothy() {
         repo = ctx.getBean(SmoothyRepository.class);
         Smoothy p = new Smoothy.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createSmoothy")
     public void readSmoothy(){
         repo = ctx.getBean(SmoothyRepository.class);
         Smoothy entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readSmoothy")
     private void updateSmoothy(){
         repo = ctx.getBean(SmoothyRepository.class);
         Smoothy entity = repo.findOne(id);
         Smoothy updatedentity = new Smoothy.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Smoothy updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateSmoothy")
     private void deleteSmoothy(){
         repo = ctx.getBean(SmoothyRepository.class);
         Smoothy person = repo.findOne(id);
         repo.delete(person);
         Smoothy deletedPerson = repo.findOne(id);
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
