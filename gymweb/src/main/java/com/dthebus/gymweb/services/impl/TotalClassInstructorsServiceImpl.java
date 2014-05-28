/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.employees.ClassInstructor;
import com.dthebus.gymweb.repository.ClassInstructorRepository;
import com.dthebus.gymweb.services.TotalClassInstructorsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalClassInstructorsServiceImpl implements TotalClassInstructorsService{
@Autowired
    private ClassInstructorRepository cir;
    
    @Override
    public List<ClassInstructor> getTotal() {
    return cir.findAll();    
    }

    @Override
    public double getSalary(int id) {
      List<ClassInstructor> all = cir.findAll();
      for(ClassInstructor a : all)
          if(a.getId()==id)
              return a.getSalary();
      return 0;}
}
