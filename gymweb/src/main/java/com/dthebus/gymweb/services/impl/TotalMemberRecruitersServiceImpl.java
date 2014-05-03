/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.MemberRecruiter;
import com.dthebus.gymweb.repository.MemberRecruiterRepository;
import com.dthebus.gymweb.services.TotalMemberRecruitersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalMemberRecruitersServiceImpl implements TotalMemberRecruitersService{
@Autowired
    private MemberRecruiterRepository fullMemberRepository;
    
    @Override
    public List<MemberRecruiter> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
