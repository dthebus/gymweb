/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.shop.Statement;
import com.dthebus.gymweb.repository.StatementRepository;
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
public class StatementTest {
    
     public static ApplicationContext ctx;
    private Long id;

    private static StatementRepository repo;
    public StatementTest() {
    }

      @Test
      public void createStatement() {
         repo = ctx.getBean(StatementRepository.class);
         Statement p = new Statement.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createStatement")
     public void readStatement(){
         repo = ctx.getBean(StatementRepository.class);
         Statement entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readStatement")
     private void updateStatement(){
         repo = ctx.getBean(StatementRepository.class);
         Statement entity = repo.findOne(id);
         Statement updatedentity = new Statement.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Statement updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateStatement")
     private void deleteStatement(){
         repo = ctx.getBean(StatementRepository.class);
         Statement person = repo.findOne(id);
         repo.delete(person);
         Statement deletedPerson = repo.findOne(id);
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
