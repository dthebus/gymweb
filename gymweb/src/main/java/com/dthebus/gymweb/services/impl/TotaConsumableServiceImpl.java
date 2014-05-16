/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Consumable;
import com.dthebus.gymweb.repository.ConsumableRepository;
import com.dthebus.gymweb.services.TotalConsumableService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotaConsumableServiceImpl implements TotalConsumableService{
@Autowired
    private ConsumableRepository fullMemberRepository;
    
    @Override
    public List<Consumable> getTotal() {
    return fullMemberRepository.findAll();    
    }
    
}
