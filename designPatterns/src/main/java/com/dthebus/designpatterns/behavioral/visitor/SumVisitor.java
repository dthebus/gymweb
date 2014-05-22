/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.visitor;

/**
 *
 * @author darren
 */
public class SumVisitor implements Numbervisitor{

    @Override
    public void visit(TwoElement twoElement) {
    
    }

    @Override
    public void visit(ThreeElement threeElement) {
    
    }

    @Override
    public void visit(Object elementList) {
   for(NumberElement ne : elementList)
       ne.accept(this);
    }
    
}
