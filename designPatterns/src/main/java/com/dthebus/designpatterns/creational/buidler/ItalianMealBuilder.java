/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.creational.buidler;

/**
 *
 * @author darren
 */
public class ItalianMealBuilder implements MealBuilder{

    private Meal meal;
    public ItalianMealBuilder ()
    {
        meal= new Meal();
    }
    
    public void buildDrink() {
    meal.setDrink("red wine");
    }

    public void buildMainCourse() {
        meal.setMaincourse("pizza");
    }

    public void buildSide() {
        meal.setSide("bread");
    }

    public Meal getMeal() {
      return meal;
    }
    
}
