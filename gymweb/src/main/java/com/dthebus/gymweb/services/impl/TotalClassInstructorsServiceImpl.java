/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.ClassInstructor;
import com.dthebus.gymweb.repository.ClassInstructorRepository;
import com.dthebus.gymweb.services.TotalClassInstructorsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalClassInstructorsServiceImpl implements TotalClassInstructorsService{
@Autowired
    private ClassInstructorRepository fullMemberRepository;
    
    @Override
    public List<ClassInstructor> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
