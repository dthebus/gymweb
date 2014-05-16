/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.employees.Cleaner;
import com.dthebus.gymweb.repository.CleanerRepository;
import com.dthebus.gymweb.services.TotalCleanersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalCleanersServiceImpl implements TotalCleanersService{
@Autowired
    private CleanerRepository fullMemberRepository;
    
    @Override
    public List<Cleaner> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
