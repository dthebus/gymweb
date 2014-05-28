/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.test.restapi;

import com.dthebus.gymweb.domain.accounts.Fees;
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
public class FeesControllerTest {
    
    public FeesControllerTest() {
    }
     private RestTemplate restTemplate = new RestTemplate();
   private final static String URL = "http://localhost:8084/gymweb/";
   
   @Test
   public void testCreate(){
       Fees d = new Fees.Builder("Monthly").build();
       HttpEntity<Fees> requestEntity = new HttpEntity<>(d, getContentType());
  
   ResponseEntity<String> responseEntity = restTemplate.
           exchange(URL+"api/fees/create", HttpMethod.POST, requestEntity, String.class);
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
