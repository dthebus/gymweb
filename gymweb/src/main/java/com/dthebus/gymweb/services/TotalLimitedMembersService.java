/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.members.LimitedMember;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalLimitedMembersService {
     public List<LimitedMember> getTotalPeople();
     public List<LimitedMember> getTotalmembersUnderageof(int age);
}
