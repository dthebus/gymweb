/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.members.LimitedMember;
import com.dthebus.gymweb.repository.LimitedMemberRepository;
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
public class LimitedMemberTest {
    public static ApplicationContext ctx;
    private Long id;

    private static LimitedMemberRepository repo;
    public LimitedMemberTest() {
    }

    @Test
      public void createFullMember() {
         repo = ctx.getBean(LimitedMemberRepository.class);
         LimitedMember p = new LimitedMember.Builder("Darren").surname("Thebus").age(23).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
     
     @Test(dependsOnMethods = "createFullMember")
     public void readFullMember(){
         repo = ctx.getBean(LimitedMemberRepository.class);
         LimitedMember person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Darren");
      }
     
    @Test(dependsOnMethods = "readFullMember")
     private void updateFullMember(){
         repo = ctx.getBean(LimitedMemberRepository.class);
         LimitedMember person = repo.findOne(id);
         LimitedMember updatedperson = new LimitedMember.Builder("Darren").person(person).surname("Lee").build();
         repo.save(updatedperson);
         LimitedMember updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getSurname(), "Lee");
     }
     
     @Test(dependsOnMethods = "updateFullMember")
     private void deleteFullMember(){
         repo = ctx.getBean(LimitedMemberRepository.class);
         LimitedMember person = repo.findOne(id);
         repo.delete(person);
         LimitedMember deletedPerson = repo.findOne(id);
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
