/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.structural.decorator;

/**
 *
 * @author darren
 */
public class LivingAnimal implements Animal{

    @Override
    public String describe() {
     return "living";
    }
    
}
