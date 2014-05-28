/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.members.LimitedMember;
import com.dthebus.gymweb.services.TotalLimitedMembersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author darren
 */
@Controller
@RequestMapping(value = "api/limited")
public class LimitedMemberController {
  
    @Autowired
    TotalLimitedMembersService lms;
    
    @RequestMapping(value="all", method = RequestMethod.GET)
    @ResponseBody
    public List<LimitedMember> getall(){
      return lms.getTotalPeople();
    }
    
    @RequestMapping(value="under/{age}", method = RequestMethod.GET)
    @ResponseBody
  public List<LimitedMember> under(@PathVariable int age){
      return lms.getTotalmembersUnderageof(age);
  }
}
