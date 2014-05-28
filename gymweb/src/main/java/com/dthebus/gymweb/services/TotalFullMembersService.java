/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.members.FullMember;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalFullMembersService extends Services<FullMember, Long>{
    public List<FullMember> getTotalPeople();
    public List<FullMember> getTotalmembersUnderageof(int age);
}
