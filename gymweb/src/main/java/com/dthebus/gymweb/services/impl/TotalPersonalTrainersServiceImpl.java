/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.employees.PersonalTrainer;
import com.dthebus.gymweb.repository.PersonalTrainerRepository;
import com.dthebus.gymweb.services.TotalPersonalTrainersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalPersonalTrainersServiceImpl implements TotalPersonalTrainersService{
@Autowired
    private PersonalTrainerRepository ptr;
    
    @Override
    public List<PersonalTrainer> getTotal() {
    return ptr.findAll();    
    }

    @Override
    public double getSalary(int id) {
    List<PersonalTrainer> all = ptr.findAll();
      for(PersonalTrainer a : all)
          if(a.getId()==id)
              return a.getSalary();
      return 0;}
    
     public PersonalTrainer persist(PersonalTrainer entity) {
     return ptr.save(entity);
    }
}
