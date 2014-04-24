/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.ClassInstructor;
import com.dthebus.gymweb.repository.ClassInstructorRepository;
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
public class ClassInstructorTest {
    public static ApplicationContext ctx;
    private Long id;

    private static ClassInstructorRepository repo;
    public ClassInstructorTest() {
    }

     @Test
      public void createClassInstructor() {
         repo = ctx.getBean(ClassInstructorRepository.class);
         ClassInstructor p = new ClassInstructor.Builder("Darren").surname("Thebus").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
     
     @Test(dependsOnMethods = "createClassInstructor")
     public void readClassInstructor(){
         repo = ctx.getBean(ClassInstructorRepository.class);
         ClassInstructor person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Darren");
      }
     
    @Test(dependsOnMethods = "readClassInstructor")
     private void updateClassInstructor(){
         repo = ctx.getBean(ClassInstructorRepository.class);
         ClassInstructor person = repo.findOne(id);
         ClassInstructor updatedperson = new ClassInstructor.Builder("Darren").person(person).surname("Lee").build();
         repo.save(updatedperson);
         ClassInstructor updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getSurname(), "Lee");
     }
     
     @Test(dependsOnMethods = "updateClassInstructor")
     private void deleteClassInstructor(){
         repo = ctx.getBean(ClassInstructorRepository.class);
         ClassInstructor person = repo.findOne(id);
         repo.delete(person);
         ClassInstructor deletedPerson = repo.findOne(id);
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
