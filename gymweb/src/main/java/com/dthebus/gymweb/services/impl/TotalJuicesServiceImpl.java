/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.Juice;
import com.dthebus.gymweb.repository.JuiceRepository;
import com.dthebus.gymweb.services.TotalJuicesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalJuicesServiceImpl implements TotalJuicesService{
@Autowired
    private JuiceRepository fullMemberRepository;
    
    @Override
    public List<Juice> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
