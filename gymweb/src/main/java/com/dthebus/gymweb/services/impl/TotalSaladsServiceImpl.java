/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Salad;
import com.dthebus.gymweb.repository.SaladRepository;
import com.dthebus.gymweb.services.TotalSaladsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalSaladsServiceImpl implements TotalSaladsService{
@Autowired
    private SaladRepository fullMemberRepository;
    
    @Override
    public List<Salad> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
