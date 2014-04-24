/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.SnackBar;
import com.dthebus.gymweb.repository.SnackBarRepository;
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
public class SnackBarTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static SnackBarRepository repo;
    public SnackBarTest() {
    }

      @Test
      public void createSnackBar() {
         repo = ctx.getBean(SnackBarRepository.class);
         SnackBar p = new SnackBar.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createSnackBar")
     public void readSnackBar(){
         repo = ctx.getBean(SnackBarRepository.class);
         SnackBar entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readSnackBar")
     private void updateSnackBar(){
         repo = ctx.getBean(SnackBarRepository.class);
         SnackBar entity = repo.findOne(id);
         SnackBar updatedentity = new SnackBar.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         SnackBar updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateSnackBar")
     private void deleteSnackBar(){
         repo = ctx.getBean(SnackBarRepository.class);
         SnackBar person = repo.findOne(id);
         repo.delete(person);
         SnackBar deletedPerson = repo.findOne(id);
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
