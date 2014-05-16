/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.department.Supplier;
import com.dthebus.gymweb.repository.SupplierRepository;
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
public class SupplierTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static SupplierRepository repo;
    public SupplierTest() {
    }

      @Test
      public void createSupplier() {
         repo = ctx.getBean(SupplierRepository.class);
         Supplier p = new Supplier.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createSupplier")
     public void readSupplier(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readSupplier")
     private void updateSupplier(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier entity = repo.findOne(id);
         Supplier updatedentity = new Supplier.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Supplier updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateSupplier")
     private void deleteSupplier(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier person = repo.findOne(id);
         repo.delete(person);
         Supplier deletedPerson = repo.findOne(id);
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
