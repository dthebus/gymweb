/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Trainer;
import com.dthebus.gymweb.repository.TrainerRepository;
import com.dthebus.gymweb.services.TotalTrainersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalTrainersServiceImpl implements TotalTrainersService{
@Autowired
    private TrainerRepository fullMemberRepository;
    
    @Override
    public List<Trainer> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
