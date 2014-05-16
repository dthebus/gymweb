/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.members.FullMember;
import com.dthebus.gymweb.repository.FullMemberRepository;
import com.dthebus.gymweb.services.TotalFullMembersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalFullMembersServiceImpl implements TotalFullMembersService{
@Autowired
    private FullMemberRepository fullMemberRepository;
    
    @Override
    public List<FullMember> getTotalPeople() {
    return fullMemberRepository.findAll();    
    }
    
}
