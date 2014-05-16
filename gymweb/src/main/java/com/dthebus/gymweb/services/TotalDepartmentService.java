/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.department.Department;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalDepartmentService {
    public List<Department> getTotal();
}
