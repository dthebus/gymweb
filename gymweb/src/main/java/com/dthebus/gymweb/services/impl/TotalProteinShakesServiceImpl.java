/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.ProteinShake;
import com.dthebus.gymweb.repository.ProteinShakeRepository;
import com.dthebus.gymweb.services.TotalProteinShakesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalProteinShakesServiceImpl implements TotalProteinShakesService{
@Autowired
    private ProteinShakeRepository fullMemberRepository;
    
    @Override
    public List<ProteinShake> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
