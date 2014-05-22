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
public class TwoElement implements NumberElement{
    int a;
    int b;
    
    public TwoElement(int a, int b){
        this.a = a;
        this.b= b;
    }

    @Override
    public void accept(Numbervisitor visitor) {
      visitor.visit(this);
    }
}
