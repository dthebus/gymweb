/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.repository;

import com.dthebus.gymweb.domain.LimitedMember;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author darren
 */
public interface LimitedMemberRepository extends JpaRepository<LimitedMember, Long>{
    
}
