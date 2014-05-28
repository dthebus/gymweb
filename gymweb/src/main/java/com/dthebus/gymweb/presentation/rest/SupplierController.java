/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.department.Supplier;
import com.dthebus.gymweb.services.TotaSupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author darren
 */
@Controller
@RequestMapping(value="api/supplier")
public class SupplierController {
    @Autowired
    TotaSupplierService tss;
 @RequestMapping(value="all", method= RequestMethod.GET)
 @ResponseBody
 public List<Supplier> all(){
     return tss.findAll();
 }
  
 @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Supplier sup){
        tss.persist(sup);
        return "Supplier Created";
    }
}
