/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.SnackBar;
import com.dthebus.gymweb.repository.SnackBarRepository;
import com.dthebus.gymweb.services.TotalSnackBarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalSnackBarServiceImpl implements TotalSnackBarService{
@Autowired
    private SnackBarRepository fullMemberRepository;
    
    @Override
    public List<SnackBar> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
