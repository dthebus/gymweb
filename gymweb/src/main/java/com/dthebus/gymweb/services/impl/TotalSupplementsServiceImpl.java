/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Supplement;
import com.dthebus.gymweb.repository.SupplementRepository;
import com.dthebus.gymweb.services.TotalSupplementsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalSupplementsServiceImpl implements TotalSupplementsService{
@Autowired
    private SupplementRepository fullMemberRepository;
    
    @Override
    public List<Supplement> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
