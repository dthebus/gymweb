/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.accounts.Fees;
import com.dthebus.gymweb.repository.FeesRepository;
import com.dthebus.gymweb.services.TotalFeesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalFeesServiceImpl implements TotalFeesService{
@Autowired
    private FeesRepository feeRepository;
    
    @Override
    public List<Fees> getTotal() {
    return feeRepository.findAll();    
    }

    @Override
    public double getPrice(String type) {
    List<Fees> all = feeRepository.findAll();
    for( Fees e: all)
        if (e.getType().equals(type))
            return e.getPrice();
    return 0;
    }

    @Override
    public Fees find(Long id) {
    return feeRepository.findOne(id);
    }

    @Override
    public Fees persist(Fees entity) {
    return feeRepository.save(entity);
    }

    @Override
    public Fees merge(Fees entity) {
      if(entity.getId()!=null)
          return feeRepository.save(entity);
      return null;
    }

    @Override
    public void remove(Fees entity) {
    feeRepository.delete(entity);
    }

    @Override
    public List<Fees> findAll() {
    return feeRepository.findAll();
    }
}
