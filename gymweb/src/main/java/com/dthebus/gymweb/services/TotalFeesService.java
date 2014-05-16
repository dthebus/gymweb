/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.accounts.Fees;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalFeesService {
    public List<Fees> getTotal();
}
