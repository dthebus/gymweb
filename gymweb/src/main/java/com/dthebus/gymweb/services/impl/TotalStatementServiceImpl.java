/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.shop.Statement;
import com.dthebus.gymweb.repository.StatementRepository;
import com.dthebus.gymweb.services.TotalStatementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalStatementServiceImpl implements TotalStatementService{
@Autowired
    private StatementRepository fullMemberRepository;
    
    @Override
    public List<Statement> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
