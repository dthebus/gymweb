/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation.rest;

import com.dthebus.gymweb.domain.employees.AccessController;
import com.dthebus.gymweb.domain.employees.AdminStaff;
import com.dthebus.gymweb.domain.employees.ClassInstructor;
import com.dthebus.gymweb.domain.employees.Cleaner;
import com.dthebus.gymweb.domain.employees.Manager;
import com.dthebus.gymweb.domain.employees.MemberRecruiter;
import com.dthebus.gymweb.domain.employees.PersonalTrainer;
import com.dthebus.gymweb.domain.employees.Trainer;
import com.dthebus.gymweb.services.TotalAccessControllersService;
import com.dthebus.gymweb.services.TotalAdminStaffService;
import com.dthebus.gymweb.services.TotalClassInstructorsService;
import com.dthebus.gymweb.services.TotalCleanersService;
import com.dthebus.gymweb.services.TotalManagersService;
import com.dthebus.gymweb.services.TotalMemberRecruitersService;
import com.dthebus.gymweb.services.TotalPersonalTrainersService;
import com.dthebus.gymweb.services.TotalTrainersService;
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
@RequestMapping(value="api/staff")
public class StaffController {
    @Autowired
    TotalAccessControllersService tacs;
    @Autowired
    TotalAdminStaffService tass;
    @Autowired
    TotalClassInstructorsService tcis;
    @Autowired
    TotalCleanersService tcs;
    @Autowired
    TotalManagersService tms;
    @Autowired
    TotalMemberRecruitersService tmrs;
    @Autowired
    TotalPersonalTrainersService tpts;
    @Autowired
    TotalTrainersService tts;
   
    @RequestMapping(value ="accessstaff/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double ac(@PathVariable int id){
        return tacs.getSalary(id);
        
    }
     @RequestMapping(value = "accessstaff/all", method= RequestMethod.GET)
    @ResponseBody
    public List<AccessController> getAllac(){
        return tacs.getTotal();
    }
    
     @RequestMapping(value = "accessstaff/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody AccessController ac){
        tacs.persist(ac);
        return "AccessStaff Created";
    }
    
    @RequestMapping(value ="admin/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double as(@PathVariable int id){
        return tass.getSalary(id);
        
    }
     @RequestMapping(value = "admin/all", method= RequestMethod.GET)
    @ResponseBody
    public List<AdminStaff> getAllad(){
        return tass.getTotal();
    }
    
     @RequestMapping(value = "admin/create", method = RequestMethod.POST)
    @ResponseBody
    public String create1(@RequestBody AdminStaff as){
        tass.persist(as);
        return "AdminStaff Created";
    }
    
    @RequestMapping(value ="instructor/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double ins(@PathVariable int id){
        return tcis.getSalary(id);
        
    }
     @RequestMapping(value = "instructor/all", method= RequestMethod.GET)
    @ResponseBody
    public List<ClassInstructor> getAllins(){
        return tcis.getTotal();
    }
    
     @RequestMapping(value = "instructor/create", method = RequestMethod.POST)
    @ResponseBody
    public String create2(@RequestBody ClassInstructor ci){
        tcis.persist(ci);
        return "ClassInstructor Created";
    }
    
    @RequestMapping(value ="cleaner/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double cs(@PathVariable int id){
        return tcs.getSalary(id);
        
    }
     @RequestMapping(value = "cleaner/all", method= RequestMethod.GET)
    @ResponseBody
    public List<Cleaner> getAllcs(){
        return tcs.getTotal();
    }
    
    @RequestMapping(value = "cleaner/create", method = RequestMethod.POST)
    @ResponseBody
    public String create3(@RequestBody Cleaner c){
        tcs.persist(c);
        return "Cleaner Created";
    }
    
     @RequestMapping(value ="manager/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double m(@PathVariable int id){
        return tms.getSalary(id);
        
    }
     @RequestMapping(value = "manager/all", method= RequestMethod.GET)
    @ResponseBody
    public List<Manager> getAllm(){
        return tms.getTotal();
    }
    @RequestMapping(value = "manager/create", method = RequestMethod.POST)
    @ResponseBody
    public String create3(@RequestBody Manager m){
        tms.persist(m);
        return "Manager Created";
    }
    
     @RequestMapping(value ="recruiter/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double rs(@PathVariable int id){
        return tmrs.getSalary(id);
        
    }
     @RequestMapping(value = "recruiter/all", method= RequestMethod.GET)
    @ResponseBody
    public List<MemberRecruiter> getAllrs(){
        return tmrs.getTotal();
    }
    
     @RequestMapping(value = "recruiter/create", method = RequestMethod.POST)
    @ResponseBody
    public String create3(@RequestBody MemberRecruiter mr){
        tmrs.persist(mr);
        return "MemberRecruiter Created";
    }
    
     @RequestMapping(value ="personaltrainer/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double gtpts(@PathVariable int id){
        return tpts.getSalary(id);
        
    }
     @RequestMapping(value = "personaltrainer/all", method= RequestMethod.GET)
    @ResponseBody
    public List<PersonalTrainer> getAlltpts(){
        return tpts.getTotal();
    }
    
    @RequestMapping(value = "personaltrainer/create", method = RequestMethod.POST)
    @ResponseBody
    public String create3(@RequestBody PersonalTrainer pt){
        tpts.persist(pt);
        return "PersonalTrainer Created";
    }
    
     @RequestMapping(value ="trainer/salary/{id}", method = RequestMethod.GET)
    @ResponseBody
    public double gtts(@PathVariable int id){
        return tts.getSalary(id);
        
    }
     @RequestMapping(value = "trainer/all", method= RequestMethod.GET)
    @ResponseBody
    public List<Trainer> getAlltts(){
        return tts.getTotal();
    }
    
     @RequestMapping(value = "trainer/create", method = RequestMethod.POST)
    @ResponseBody
    public String create3(@RequestBody Trainer t){
        tts.persist(t);
        return "Trainer Created";
    }
}
