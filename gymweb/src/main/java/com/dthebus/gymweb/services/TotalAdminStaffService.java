/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.employees.AdminStaff;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalAdminStaffService {
    public List<AdminStaff> getTotal();
     public double getSalary(int id);
      public AdminStaff persist(AdminStaff entity);
}
