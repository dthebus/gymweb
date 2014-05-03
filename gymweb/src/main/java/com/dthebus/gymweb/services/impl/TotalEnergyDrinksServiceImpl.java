/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.EnergyDrink;
import com.dthebus.gymweb.repository.EnergyDrinkRepository;
import com.dthebus.gymweb.services.TotalEnergyDrinksService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalEnergyDrinksServiceImpl implements TotalEnergyDrinksService{
@Autowired
    private EnergyDrinkRepository fullMemberRepository;
    
    @Override
    public List<EnergyDrink> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
