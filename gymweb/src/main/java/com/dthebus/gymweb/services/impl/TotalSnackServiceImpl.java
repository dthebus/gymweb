/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.shop.Snack;
import com.dthebus.gymweb.repository.SnackRepository;
import com.dthebus.gymweb.services.TotalSnackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalSnackServiceImpl implements TotalSnackService{
@Autowired
    private SnackRepository fullMemberRepository;
    
    @Override
    public List<Snack> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
