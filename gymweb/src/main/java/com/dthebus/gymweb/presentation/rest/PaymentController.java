/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.accounts.Payment;
import com.dthebus.gymweb.services.TotalPaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author darren
 */
@Controller
@RequestMapping(value="api/payments")
public class PaymentController {
    @Autowired
    private TotalPaymentService paymentService;
    
    @RequestMapping(value= "all", method= RequestMethod.GET)
    @ResponseBody
    public List<Payment> getall(){
        return paymentService.findAll();
    }
  
    @RequestMapping(value="memberID/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Payment> memberPayments(@PathVariable int id){
        return paymentService.getTotalPaymentsOfMember(id);
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Payment pay){
        paymentService.persist(pay);
        return "Payment Created";
    }
    }
