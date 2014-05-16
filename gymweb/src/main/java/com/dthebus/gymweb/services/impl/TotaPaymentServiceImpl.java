/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.accounts.Payment;
import com.dthebus.gymweb.repository.PaymentRepository;
import com.dthebus.gymweb.services.TotalPaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotaPaymentServiceImpl implements TotalPaymentService{
@Autowired
    private PaymentRepository fullMemberRepository;
    
    @Override
    public List<Payment> getTotal() {
    return fullMemberRepository.findAll();    
    }
}
