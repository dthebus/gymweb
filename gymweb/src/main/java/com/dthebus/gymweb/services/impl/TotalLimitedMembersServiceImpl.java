/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.members.LimitedMember;
import com.dthebus.gymweb.repository.LimitedMemberRepository;
import com.dthebus.gymweb.services.TotalLimitedMembersService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalLimitedMembersServiceImpl implements TotalLimitedMembersService{
    @Autowired
    private LimitedMemberRepository limitedMemberRepository;
    
    @Override
    public List<LimitedMember> getTotalPeople() {
    return limitedMemberRepository.findAll();    
    }

    @Override
    public List<LimitedMember> getTotalmembersUnderageof(int age) {
   List<LimitedMember> allmembers = limitedMemberRepository.findAll();
        List<LimitedMember> membersunderageof = new ArrayList();
        for(LimitedMember mem : allmembers){
            if(age > mem.getAge())
                membersunderageof.add(mem);
        }
        return membersunderageof;
    }
}
