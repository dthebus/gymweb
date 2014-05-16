/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.repository;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.department.Equipment;
import com.dthebus.gymweb.repository.EquipmentRepository;
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
public class EquipmentTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private static EquipmentRepository repo;
    public EquipmentTest() {
    }

      @Test
      public void createEquipment() {
         repo = ctx.getBean(EquipmentRepository.class);
         Equipment p = new Equipment.Builder("USN").price(125.55).build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
      }
      
    @Test(dependsOnMethods = "createEquipment")
     public void readEquipment(){
         repo = ctx.getBean(EquipmentRepository.class);
         Equipment entity = repo.findOne(id);
         Assert.assertEquals(entity.getName(), "USN");
      }
     
    @Test(dependsOnMethods = "readEquipment")
     private void updateEquipment(){
         repo = ctx.getBean(EquipmentRepository.class);
         Equipment entity = repo.findOne(id);
         Equipment updatedentity = new Equipment.Builder("USN").entity(entity).price(126.25).build();
         repo.save(updatedentity);
         Equipment updateEntity = repo.findOne(id);
         Assert.assertEquals(updateEntity.getPrice(), 126.25);
     }
     
     @Test(dependsOnMethods = "updateEquipment")
     private void deleteEquipment(){
         repo = ctx.getBean(EquipmentRepository.class);
         Equipment person = repo.findOne(id);
         repo.delete(person);
         Equipment deletedPerson = repo.findOne(id);
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
