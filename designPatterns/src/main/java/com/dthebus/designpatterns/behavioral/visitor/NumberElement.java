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
public interface NumberElement {
    public void accept(NumberVisitor visitor);
}
