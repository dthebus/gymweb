/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.employees.AdminStaff;
import com.dthebus.gymweb.repository.AdminStaffRepository;
import com.dthebus.gymweb.services.TotalAdminStaffService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalAdminStaffServiceImpl implements TotalAdminStaffService{
@Autowired
    private AdminStaffRepository asr;
    
    @Override
    public List<AdminStaff> getTotal() {
    return asr.findAll();    
    }

    @Override
    public double getSalary(int id) {
        List<AdminStaff> all = asr.findAll();
      for(AdminStaff a : all)
          if(a.getId()==id)
              return a.getSalary();
      return 0;}
    
    @Override
    public AdminStaff persist(AdminStaff entity) {
     return asr.save(entity);
    }
}
