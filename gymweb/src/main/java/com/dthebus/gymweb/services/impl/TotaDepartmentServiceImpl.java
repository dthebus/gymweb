/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.department.Department;
import com.dthebus.gymweb.repository.DepartmentRepository;
import com.dthebus.gymweb.services.TotalDepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotaDepartmentServiceImpl implements TotalDepartmentService{
@Autowired
    private DepartmentRepository dr;
    
    @Override
    public List<Department> getTotal() {
    return dr.findAll();    
    }
    public Department persist(Department entity) {
     return dr.save(entity);
    }
}
