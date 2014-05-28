/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.accounts.Payment;
import com.dthebus.gymweb.repository.PaymentRepository;
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
public class PaymentTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static PaymentRepository repo;
    public PaymentTest() {
    }

      @Test
      public void createPayment() {
         repo = ctx.getBean(PaymentRepository.class);
         Payment p = new Payment.Builder(2).amount(125.55).build();
         repo.save(p);
         id = p.getpaymentId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createPayment")
     public void readPayment(){
         repo = ctx.getBean(PaymentRepository.class);
         Payment entity = repo.findOne(id);
         Assert.assertEquals(entity.getmemberID(), 2);
      }
     
   @Test(dependsOnMethods = "readPayment")
     private void updatePayment(){
         repo = ctx.getBean(PaymentRepository.class);
         Payment entity = repo.findOne(id);
         Payment updatedentity = new Payment.Builder(2).entity(entity).amount(126.25).build();
         repo.save(updatedentity);
         Payment updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getAmount(), 126.25);
     }
     
     @Test(dependsOnMethods = "updatePayment")
     private void deletePayment(){
         repo = ctx.getBean(PaymentRepository.class);
         Payment person = repo.findOne(id);
         repo.delete(person);
         Payment deletedPerson = repo.findOne(id);
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
