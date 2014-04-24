/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Trainer;
import com.dthebus.gymweb.repository.TrainerRepository;
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
public class TrainerTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static TrainerRepository repo;
    public TrainerTest() {
    }

     @Test
      public void createTrainer() {
         repo = ctx.getBean(TrainerRepository.class);
         Trainer p = new Trainer.Builder("Darren").surname("Thebus").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
     
     @Test(dependsOnMethods = "createTrainer")
     public void readTrainer(){
         repo = ctx.getBean(TrainerRepository.class);
         Trainer person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Darren");
      }
     
    @Test(dependsOnMethods = "readTrainer")
     private void updateTrainer(){
         repo = ctx.getBean(TrainerRepository.class);
         Trainer person = repo.findOne(id);
         Trainer updatedperson = new Trainer.Builder("Darren").person(person).surname("Lee").build();
         repo.save(updatedperson);
         Trainer updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getSurname(), "Lee");
     }
     
     @Test(dependsOnMethods = "updateTrainer")
     private void deleteTrainer(){
         repo = ctx.getBean(TrainerRepository.class);
         Trainer person = repo.findOne(id);
         repo.delete(person);
         Trainer deletedPerson = repo.findOne(id);
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
