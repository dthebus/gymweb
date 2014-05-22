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
public abstract class Expression {
    public abstract void interpret(Context context);
}
