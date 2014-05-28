/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.department.Department;
import com.dthebus.gymweb.services.TotalDepartmentService;
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
@RequestMapping(value="api/department")
public class DepartmentController {
  @Autowired
  TotalDepartmentService tds;
  
  @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Department department){
        tds.persist(department);
        return "department Created";
    }
  @RequestMapping(value = "all", method= RequestMethod.GET)
  @ResponseBody
  public List<Department> all(){
      return tds.getTotal();
  }
}
