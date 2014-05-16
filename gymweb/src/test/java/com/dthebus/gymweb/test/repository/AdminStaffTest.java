/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.employees.AdminStaff;
import com.dthebus.gymweb.repository.AdminStaffRepository;
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
public class AdminStaffTest {
    public static ApplicationContext ctx;
    private Long id;

    private static AdminStaffRepository repo;
    public AdminStaffTest() {
    }

     @Test
      public void createAdminStaff() {
         repo = ctx.getBean(AdminStaffRepository.class);
         AdminStaff p = new AdminStaff.Builder("Darren").surname("Thebus").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
     
     @Test(dependsOnMethods = "createAdminStaff")
     public void readAdminStaff(){
         repo = ctx.getBean(AdminStaffRepository.class);
         AdminStaff person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Darren");
      }
     
    @Test(dependsOnMethods = "readAdminStaff")
     private void updateAdminStaff(){
         repo = ctx.getBean(AdminStaffRepository.class);
         AdminStaff person = repo.findOne(id);
         AdminStaff updatedperson = new AdminStaff.Builder("Darren").person(person).surname("Lee").build();
         repo.save(updatedperson);
         AdminStaff updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getSurname(), "Lee");
     }
     
     @Test(dependsOnMethods = "updateAdminStaff")
     private void deleteAdminStaff(){
         repo = ctx.getBean(AdminStaffRepository.class);
         AdminStaff person = repo.findOne(id);
         repo.delete(person);
         AdminStaff deletedPerson = repo.findOne(id);
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
