/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.employees.Trainer;
import com.dthebus.gymweb.repository.TrainerRepository;
import com.dthebus.gymweb.services.TotalTrainersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalTrainersServiceImpl implements TotalTrainersService{
@Autowired
    private TrainerRepository tr;
    
    @Override
    public List<Trainer> getTotal() {
    return tr.findAll();    
    }

    @Override
    public double getSalary(int id) {
      List<Trainer> all = tr.findAll();
      for(Trainer a : all)
          if(a.getId()==id)
              return a.getSalary();
      return 0;
    }
    
@Override
     public Trainer persist(Trainer entity) {
     return tr.save(entity);
    }
}
