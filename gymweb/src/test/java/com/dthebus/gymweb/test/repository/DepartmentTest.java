/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.department.Department;
import com.dthebus.gymweb.repository.DepartmentRepository;
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
public class DepartmentTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static DepartmentRepository repo;
    public DepartmentTest() {
    }

      @Test
      public void createSandwich() {
         repo = ctx.getBean(DepartmentRepository.class);
         Department p = new Department.Builder("Weights").managerID(1).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createSandwich")
     public void readSandwich(){
         repo = ctx.getBean(DepartmentRepository.class);
         Department entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "Weights");
      }
     
    @Test(dependsOnMethods = "readSandwich")
     private void updateSandwich(){
         repo = ctx.getBean(DepartmentRepository.class);
         Department entity = repo.findOne(id);
         Department updatedentity = new Department.Builder("Weights").entity(entity).managerID(2).build();
         repo.save(updatedentity);
         Department updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getManagerID(), 2);
     }
     
     @Test(dependsOnMethods = "updateSandwich")
     private void deleteSandwich(){
         repo = ctx.getBean(DepartmentRepository.class);
         Department person = repo.findOne(id);
         repo.delete(person);
         Department deletedPerson = repo.findOne(id);
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
