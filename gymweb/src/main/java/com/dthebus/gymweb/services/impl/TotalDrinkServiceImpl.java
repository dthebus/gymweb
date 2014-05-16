/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.shop.Drink;
import com.dthebus.gymweb.repository.DrinkRepository;
import com.dthebus.gymweb.services.TotalDrinkService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalDrinkServiceImpl implements TotalDrinkService{
@Autowired
    private DrinkRepository fullMemberRepository;
    
    @Override
    public List<Drink> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
