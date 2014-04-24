/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.HealthShake;
import com.dthebus.gymweb.repository.HealthShakeRepository;
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
public class HealthShakeTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static HealthShakeRepository repo;
    public HealthShakeTest() {
    }

      @Test
      public void createHealthShake() {
         repo = ctx.getBean(HealthShakeRepository.class);
         HealthShake p = new HealthShake.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createHealthShake")
     public void readHealthShake(){
         repo = ctx.getBean(HealthShakeRepository.class);
         HealthShake entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readHealthShake")
     private void updateHealthShake(){
         repo = ctx.getBean(HealthShakeRepository.class);
         HealthShake entity = repo.findOne(id);
         HealthShake updatedentity = new HealthShake.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         HealthShake updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateHealthShake")
     private void deleteHealthShake(){
         repo = ctx.getBean(HealthShakeRepository.class);
         HealthShake person = repo.findOne(id);
         repo.delete(person);
         HealthShake deletedPerson = repo.findOne(id);
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
