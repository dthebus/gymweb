/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.accounts.Fees;
import com.dthebus.gymweb.services.TotalFeesService;
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
@RequestMapping(value= "api/fees")
public class FeeController {
    
    @Autowired
    TotalFeesService fees;
            
    @RequestMapping(value = "all", method= RequestMethod.GET)
    @ResponseBody
    public List<Fees> allfees(){
    return fees.findAll();
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Fees fee){
        fees.persist(fee);
        return "fee Created";
    }
    
    @RequestMapping(value ="price/{type}", method =RequestMethod.GET)
    @ResponseBody
    public double getPrice(@PathVariable String type){
        return fees.getPrice(type);
    }
}
