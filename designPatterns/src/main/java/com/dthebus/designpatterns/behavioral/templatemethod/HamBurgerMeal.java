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
public class HamBurgerMeal extends Meal{

    @Override
    public String prepareIngredients() {
    return " get burger";
    }

    @Override
    public String cook() {
    return " cooking burger";
    }

    @Override
    public String cleanUp() {
        return " cleaning";
    }
    
}
