/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.creational.factorymethod;

/**
 *
 * @author darren
 */
public class Dog extends Animal{
  
    @Override
    public String makeSound() {
       return "woof";
    }
    
}
