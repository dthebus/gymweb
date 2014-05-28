/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.services;

import com.dthebus.gymweb.app.conf.ConnectionConfig;
import com.dthebus.gymweb.domain.employees.PersonalTrainer;
import com.dthebus.gymweb.services.TotalPersonalTrainersService;
import com.dthebus.gymweb.test.ConnectionConfigTest;
import static com.dthebus.gymweb.test.services.TotalClassInstructorsServiceTest.ctx;
import java.util.List;
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
public class TotalPersonalTrainersServiceTest {
    
    public TotalPersonalTrainersServiceTest() {
    }

    public static ApplicationContext ctx;
    private TotalPersonalTrainersService service;
   
   
    @Test
     public void total() {
         service = ctx.getBean(TotalPersonalTrainersService.class);
         List<PersonalTrainer> entities = service.getTotal();
         
         Assert.assertEquals(0, entities.size(), " Expect none");
     
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
