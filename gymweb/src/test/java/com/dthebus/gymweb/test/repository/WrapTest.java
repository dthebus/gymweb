/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.Wrap;
import com.dthebus.gymweb.repository.WrapRepository;
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
public class WrapTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static WrapRepository repo;
    public WrapTest() {
    }

      @Test
      public void createWrap() {
         repo = ctx.getBean(WrapRepository.class);
         Wrap p = new Wrap.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createWrap")
     public void readWrap(){
         repo = ctx.getBean(WrapRepository.class);
         Wrap entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readWrap")
     private void updateWrap(){
         repo = ctx.getBean(WrapRepository.class);
         Wrap entity = repo.findOne(id);
         Wrap updatedentity = new Wrap.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Wrap updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateWrap")
     private void deleteWrap(){
         repo = ctx.getBean(WrapRepository.class);
         Wrap person = repo.findOne(id);
         repo.delete(person);
         Wrap deletedPerson = repo.findOne(id);
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
