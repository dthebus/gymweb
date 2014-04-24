/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.ProteinShake;
import com.dthebus.gymweb.repository.ProteinShakeRepository;
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
public class ProteinShakeTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static ProteinShakeRepository repo;
    public ProteinShakeTest() {
    }

      @Test
      public void createProteinShake() {
         repo = ctx.getBean(ProteinShakeRepository.class);
         ProteinShake p = new ProteinShake.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createProteinShake")
     public void readProteinShake(){
         repo = ctx.getBean(ProteinShakeRepository.class);
         ProteinShake entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readProteinShake")
     private void updateProteinShake(){
         repo = ctx.getBean(ProteinShakeRepository.class);
         ProteinShake entity = repo.findOne(id);
         ProteinShake updatedentity = new ProteinShake.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         ProteinShake updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateProteinShake")
     private void deleteProteinShake(){
         repo = ctx.getBean(ProteinShakeRepository.class);
         ProteinShake person = repo.findOne(id);
         repo.delete(person);
         ProteinShake deletedPerson = repo.findOne(id);
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
