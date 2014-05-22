/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.visitor;

import java.util.List;

/**
 *
 * @author darren
 */
public class TotalVisitor implements NumberVisitor{
    
    int totalSum = 0;
    @Override
    public void visit(TwoElement twoElement) {
      
    }

    @Override
    public void visit(ThreeElement threeElement) {
      
    }

    @Override
    public void visit(List<NumberElement> elementList) {
     for(NumberElement ne : elementList){
         ne.accept(this);
     }
    }
     public int getTotalSum()
     {
         return totalSum;
     }
    
    
}
