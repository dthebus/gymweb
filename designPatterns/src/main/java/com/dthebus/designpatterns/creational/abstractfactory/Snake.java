/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.creational.abstractfactory;

import com.dthebus.designpatterns.creational.factorymethod.Animal;

/**
 *
 * @author darren
 */
public class Snake extends Animal {

    @Override
    public String makeSound() {
        return "Hiss";
    }
    
}
