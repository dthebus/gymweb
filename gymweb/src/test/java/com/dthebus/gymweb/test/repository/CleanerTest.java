/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Cleaner;
import com.dthebus.gymweb.repository.CleanerRepository;
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
public class CleanerTest {
    public static ApplicationContext ctx;
    private Long id;

    private static CleanerRepository repo;
    public CleanerTest() {
    }

    @Test
      public void createCleaner() {
         repo = ctx.getBean(CleanerRepository.class);
         Cleaner p = new Cleaner.Builder("Darren").surname("Thebus").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
     
     @Test(dependsOnMethods = "createCleaner")
     public void readCleaner(){
         repo = ctx.getBean(CleanerRepository.class);
         Cleaner person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Darren");
      }
     
    @Test(dependsOnMethods = "readCleaner")
     private void updateCleaner(){
         repo = ctx.getBean(CleanerRepository.class);
         Cleaner person = repo.findOne(id);
         Cleaner updatedperson = new Cleaner.Builder("Darren").person(person).surname("Lee").build();
         repo.save(updatedperson);
         Cleaner updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getSurname(), "Lee");
     }
     
     @Test(dependsOnMethods = "updateCleaner")
     private void deleteCleaner(){
         repo = ctx.getBean(CleanerRepository.class);
         Cleaner person = repo.findOne(id);
         repo.delete(person);
         Cleaner deletedPerson = repo.findOne(id);
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
