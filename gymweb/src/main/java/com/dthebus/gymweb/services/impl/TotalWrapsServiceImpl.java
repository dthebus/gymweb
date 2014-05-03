/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Wrap;
import com.dthebus.gymweb.repository.WrapRepository;
import com.dthebus.gymweb.services.TotalWrapsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalWrapsServiceImpl implements TotalWrapsService{
@Autowired
    private WrapRepository fullMemberRepository;
    
    @Override
    public List<Wrap> getTotal() {
    return fullMemberRepository.findAll();    
    }
    
}
