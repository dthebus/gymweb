/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.department.Equipment;
import com.dthebus.gymweb.services.TotalEquipmentService;
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
@RequestMapping(value="api/equipment")
public class EquipmentController {
    @Autowired
  TotalEquipmentService tes;
  
  @RequestMapping(value = "all", method= RequestMethod.GET)
  @ResponseBody
  public List<Equipment> all(){
      return tes.getTotal();
  }
  
  @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Equipment department){
        tes.persist(department);
        return "equipment Created";
    }
}
