/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.employees.Manager;
import com.dthebus.gymweb.repository.ManagerRepository;
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
public class ManagerTest {
    public static ApplicationContext ctx;
    private Long id;

    private static ManagerRepository repo;
    public ManagerTest() {
    }

   @Test
      public void createManager() {
         repo = ctx.getBean(ManagerRepository.class);
         Manager p = new Manager.Builder("Darren").surname("Thebus").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
     
     @Test(dependsOnMethods = "createManager")
     public void readManager(){
         repo = ctx.getBean(ManagerRepository.class);
         Manager person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Darren");
      }
     
    @Test(dependsOnMethods = "readManager")
     private void updateManager(){
         repo = ctx.getBean(ManagerRepository.class);
         Manager person = repo.findOne(id);
         Manager updatedperson = new Manager.Builder("Darren").person(person).surname("Lee").build();
         repo.save(updatedperson);
         Manager updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getSurname(), "Lee");
     }
     
     @Test(dependsOnMethods = "updateManager")
     private void deleteManager(){
         repo = ctx.getBean(ManagerRepository.class);
         Manager person = repo.findOne(id);
         repo.delete(person);
         Manager deletedPerson = repo.findOne(id);
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
