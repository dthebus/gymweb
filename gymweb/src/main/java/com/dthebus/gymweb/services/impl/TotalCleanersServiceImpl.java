/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.employees.Cleaner;
import com.dthebus.gymweb.repository.CleanerRepository;
import com.dthebus.gymweb.services.TotalCleanersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalCleanersServiceImpl implements TotalCleanersService{
@Autowired
    private CleanerRepository cr;
    
    @Override
    public List<Cleaner> getTotal() {
    return cr.findAll();    
    }

    @Override
    public double getSalary(int id) {
     List<Cleaner> all = cr.findAll();
      for(Cleaner a : all)
          if(a.getId()==id)
              return a.getSalary();
      return 0; }
    
    public Cleaner persist(Cleaner entity) {
     return cr.save(entity);
    }
}
