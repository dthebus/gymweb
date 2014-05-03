/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Smoothy;
import com.dthebus.gymweb.repository.SmoothyRepository;
import com.dthebus.gymweb.services.TotalSmoothyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalSmoothyServiceImpl implements TotalSmoothyService{
@Autowired
    private SmoothyRepository fullMemberRepository;
    
    @Override
    public List<Smoothy> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
