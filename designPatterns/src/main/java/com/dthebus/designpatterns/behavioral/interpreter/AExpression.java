/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.interpreter;

/**
 *
 * @author darren
 */
public class AExpression extends Expression{

    @Override
    public void interpret(Context context) {
     String input = context.getInput();
     context.setInput(input.substring(1));
     context.setOutPut(context.getOutput()+"1");
    }
    
}
