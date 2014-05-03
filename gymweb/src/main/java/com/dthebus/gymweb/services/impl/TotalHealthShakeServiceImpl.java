/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.HealthShake;
import com.dthebus.gymweb.repository.HealthShakeRepository;
import com.dthebus.gymweb.services.TotalHealthShakeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalHealthShakeServiceImpl implements TotalHealthShakeService{
@Autowired
    private HealthShakeRepository fullMemberRepository;
    
    @Override
    public List<HealthShake> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
