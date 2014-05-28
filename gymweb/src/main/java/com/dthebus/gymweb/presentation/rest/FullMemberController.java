/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.members.FullMember;
import com.dthebus.gymweb.services.TotalFullMembersService;
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
@RequestMapping(value= "api/fullmember")
public class FullMemberController {
    @Autowired
    private TotalFullMembersService fullMservice;
    
    
    
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody FullMember fullmember){
        fullMservice.persist(fullmember);
        return "Fullmember Created";
    }
    
    @RequestMapping( value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody FullMember fullmember){
        fullMservice.merge(fullmember);
        return "member update";
    }
    
    @RequestMapping(value ="id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FullMember fullmember(@PathVariable Long id){
        return fullMservice.find(id);
        
    }
    
    @RequestMapping(value = "allfullmembers", method= RequestMethod.GET)
    @ResponseBody
    public List<FullMember> getAllmems(){
        return fullMservice.findAll();
    }
    
}
