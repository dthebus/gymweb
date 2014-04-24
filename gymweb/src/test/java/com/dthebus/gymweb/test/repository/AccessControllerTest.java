/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.AccessController;
import com.dthebus.gymweb.repository.AccessControllerRepository;
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
public class AccessControllerTest {
    public static ApplicationContext ctx;
    private Long id;

    private static AccessControllerRepository repo;
    public AccessControllerTest() {
    }

      @Test
      public void createAccessController() {
         repo = ctx.getBean(AccessControllerRepository.class);
         AccessController p = new AccessController.Builder("Darren").surname("Thebus").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
     
     @Test(dependsOnMethods = "createAccessController")
     public void readAccessController(){
         repo = ctx.getBean(AccessControllerRepository.class);
         AccessController person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Darren");
      }
     
    @Test(dependsOnMethods = "readAccessController")
     private void updateAccessController(){
         repo = ctx.getBean(AccessControllerRepository.class);
         AccessController person = repo.findOne(id);
         AccessController updatedperson = new AccessController.Builder("Darren").person(person).surname("Lee").build();
         repo.save(updatedperson);
         AccessController updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getSurname(), "Lee");
     }
     
     @Test(dependsOnMethods = "updateAccessController")
     private void deleteAccessController(){
         repo = ctx.getBean(AccessControllerRepository.class);
         AccessController person = repo.findOne(id);
         repo.delete(person);
         AccessController deletedPerson = repo.findOne(id);
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
