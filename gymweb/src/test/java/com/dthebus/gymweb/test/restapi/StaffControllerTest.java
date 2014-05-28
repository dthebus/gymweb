/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.restapi;

import com.dthebus.gymweb.domain.employees.AccessController;
import com.dthebus.gymweb.domain.employees.AdminStaff;
import com.dthebus.gymweb.domain.employees.ClassInstructor;
import com.dthebus.gymweb.domain.employees.Cleaner;
import com.dthebus.gymweb.domain.employees.Manager;
import com.dthebus.gymweb.domain.employees.MemberRecruiter;
import com.dthebus.gymweb.domain.employees.PersonalTrainer;
import com.dthebus.gymweb.domain.employees.Trainer;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author darren
 */
public class StaffControllerTest {
    
    public StaffControllerTest() {
    }
     private RestTemplate restTemplate = new RestTemplate();
   private final static String URL = "http://localhost:8084/gymweb/";
   
   @Test
   public void testCreateAccessStaff(){
       AccessController d = new AccessController.Builder("David").build();
       HttpEntity<AccessController> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/accessstaff/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
   
    @Test
   public void testCreateAdminStaff(){
       AdminStaff d = new AdminStaff.Builder("David").build();
       HttpEntity<AdminStaff> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/admin/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
   
   
    @Test
   public void testCreateClassInstructor(){
       ClassInstructor d = new ClassInstructor.Builder("David").build();
       HttpEntity<ClassInstructor> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/instructor/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
   
   
    @Test
   public void testCreateCleaner(){
       Cleaner d = new Cleaner.Builder("David").build();
       HttpEntity<Cleaner> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/cleaner/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
   
     @Test
   public void testCreateManager(){
       Manager d = new Manager.Builder("David").build();
       HttpEntity<Manager> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/manager/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
   
   @Test
   public void testCreateRecruiter(){
       MemberRecruiter d = new MemberRecruiter.Builder("David").build();
       HttpEntity<MemberRecruiter> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/recruiter/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
   
   
    @Test
   public void testCreatePersonalTrainer(){
       PersonalTrainer d = new PersonalTrainer.Builder("David").build();
       HttpEntity<PersonalTrainer> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/personaltrainer/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
     @Test
   public void testCreateTrainer(){
       Trainer d = new Trainer.Builder("David").build();
       HttpEntity<Trainer> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/staff/trainer/create", HttpMethod.POST, requestEntity, String.class);
           Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
   }
   
    private HttpEntity<?> getHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
   
   private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }
}
