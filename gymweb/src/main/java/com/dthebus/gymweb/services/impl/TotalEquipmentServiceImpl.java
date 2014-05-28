/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.department.Equipment;
import com.dthebus.gymweb.repository.EquipmentRepository;
import com.dthebus.gymweb.services.TotalEquipmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalEquipmentServiceImpl implements TotalEquipmentService{
@Autowired
    private EquipmentRepository er;
    
    @Override
    public List<Equipment> getTotal() {
    return er.findAll();    
    }
     public Equipment persist(Equipment entity) {
     return er.save(entity);
    }
}
