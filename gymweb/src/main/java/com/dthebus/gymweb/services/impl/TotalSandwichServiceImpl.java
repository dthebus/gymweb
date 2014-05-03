/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Sandwich;
import com.dthebus.gymweb.repository.SandwichRepository;
import com.dthebus.gymweb.services.TotalSandwichService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalSandwichServiceImpl implements TotalSandwichService{
@Autowired
    private SandwichRepository fullMemberRepository;
    
    @Override
    public List<Sandwich> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
