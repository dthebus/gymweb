/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.employees.Trainer;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalTrainersService {
    public List<Trainer> getTotal();
    public double getSalary(int id);
}
