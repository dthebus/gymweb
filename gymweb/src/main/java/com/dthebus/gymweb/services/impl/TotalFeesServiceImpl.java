/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.accounts.Fees;
import com.dthebus.gymweb.repository.FeesRepository;
import com.dthebus.gymweb.services.TotalFeesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalFeesServiceImpl implements TotalFeesService{
@Autowired
    private FeesRepository fullMemberRepository;
    
    @Override
    public List<Fees> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
