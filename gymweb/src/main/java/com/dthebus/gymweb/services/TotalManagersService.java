/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.employees.Manager;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalManagersService {
    public List<Manager> getTotal();
}
