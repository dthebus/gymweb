/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.services.impl;

import com.dthebus.gymweb.domain.department.Supplier;
import com.dthebus.gymweb.repository.SupplierRepository;
import com.dthebus.gymweb.services.TotaSupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren
 */
@Service
public class TotalSupplierServiceImpl implements TotaSupplierService{
@Autowired
    private SupplierRepository fullMemberRepository;
    
    @Override
    public List<Supplier> getTotal() {
    return fullMemberRepository.findAll();    
    }

    @Override
    public Supplier find(Long id) {
        return fullMemberRepository.findOne(id);
    }

    @Override
    public Supplier persist(Supplier entity) {
     return fullMemberRepository.save(entity);
    }

    @Override
    public Supplier merge(Supplier entity) {
     if(entity.getId()!=null)
         return fullMemberRepository.save(entity);
     return null;
    }

    @Override
    public void remove(Supplier entity) {
     fullMemberRepository.delete(entity);
    }

    @Override
    public List<Supplier> findAll() {
     return fullMemberRepository.findAll();
    }
}
