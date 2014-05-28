/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.employees.Manager;
import com.dthebus.gymweb.repository.ManagerRepository;
import com.dthebus.gymweb.services.TotalManagersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalManagersServiceImpl implements TotalManagersService{
@Autowired
    private ManagerRepository mr;
    
    @Override
    public List<Manager> getTotal() {
    return mr.findAll();    
    }

    @Override
    public double getSalary(int id) {
       List<Manager> all = mr.findAll();
      for(Manager a : all)
          if(a.getId()==id)
              return a.getSalary();
      return 0;}
}
