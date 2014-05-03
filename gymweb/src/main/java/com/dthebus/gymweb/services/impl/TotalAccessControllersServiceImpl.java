/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.AccessController;
import com.dthebus.gymweb.repository.AccessControllerRepository;
import com.dthebus.gymweb.services.TotalAccessControllersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalAccessControllersServiceImpl implements TotalAccessControllersService{
@Autowired
    private AccessControllerRepository fullMemberRepository;
    
    @Override
    public List<AccessController> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
