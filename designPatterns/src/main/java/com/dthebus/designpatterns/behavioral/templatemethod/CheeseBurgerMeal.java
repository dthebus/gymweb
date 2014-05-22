/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.templatemethod;

/**
 *
 * @author darren
 */
public class CheeseBurgerMeal extends Meal{

    @Override
    public String prepareIngredients() {
     return " get cheese";
    }

    @Override
    public String cook() {
    return " cooking";
    }

     @Override
    public String eat() {
   return " yum";
    }
    @Override
    public String cleanUp() {
   return "clean";
    }

   
    
}
