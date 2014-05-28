/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.members.FullMember;
import com.dthebus.gymweb.repository.FullMemberRepository;
import com.dthebus.gymweb.services.TotalFullMembersService;
import java.util.ArrayList;
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

    @Override
    public FullMember find(Long id) {
     return fullMemberRepository.findOne(id);
    }

    @Override
    public FullMember persist(FullMember entity) {
     return fullMemberRepository.save(entity);
    }

    @Override
    public FullMember merge(FullMember entity) {
    if(entity.getId()!=null){
        return fullMemberRepository.save(entity);
    }
    return null;
    }

    @Override
    public void remove(FullMember entity) {
    fullMemberRepository.delete(entity);
    }

    @Override
    public List<FullMember> findAll() {
     return fullMemberRepository.findAll();
    }

    @Override
    public List<FullMember> getTotalmembersUnderageof(int age) {
        List<FullMember> allmembers = fullMemberRepository.findAll();
        List<FullMember> membersunderageof = new ArrayList();
        for(FullMember mem : allmembers){
            if(age > mem.getAge())
                membersunderageof.add(mem);
        }
        return membersunderageof;
    }
}
