/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services;

import com.dthebus.gymweb.domain.accounts.Payment;
import java.util.List;

/**
 *
 * @author darren
 */
public interface TotalPaymentService extends Services<Payment, Long>{
    public List<Payment> getTotal();
    public List<Payment> getTotalPaymentsOfMember(int id);
}
