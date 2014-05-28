/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.accounts.Payment;
import com.dthebus.gymweb.repository.PaymentRepository;
import com.dthebus.gymweb.services.TotalPaymentService;
import java.util.ArrayList;
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
    private PaymentRepository paymentRepository;
    
    @Override
    public List<Payment> getTotal() {
    return paymentRepository.findAll();    
    }

    @Override
    public List<Payment> getTotalPaymentsOfMember(int id) {
      List<Payment> all = paymentRepository.findAll();
      List<Payment> ofmember = new ArrayList<>();
      for (Payment p : all)
          if( id== p.getmemberID())
              ofmember.add(p);
      return ofmember;
    }

    @Override
    public Payment find(Long id) {
     return paymentRepository.findOne(id);
    }

    @Override
    public Payment persist(Payment entity) {
        return paymentRepository.save(entity);
    }

    @Override
    public Payment merge(Payment entity) {
      if(entity.getpaymentId()!= null)
          return paymentRepository.save(entity);
      return null;
    }

    @Override
    public void remove(Payment entity) {
       paymentRepository.delete(entity);
    }

    @Override
    public List<Payment> findAll() {
     return paymentRepository.findAll();
    }
}
