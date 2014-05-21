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
public class JapaneseMealBuilder implements MealBuilder{
    
    private Meal meal;
    public JapaneseMealBuilder()
    {
        meal= new Meal();
    }
     public void buildDrink() {
    meal.setDrink("sake");
    }

    public void buildMainCourse() {
        meal.setMaincourse("chicken teriyaki");
    }

    public void buildSide() {
        meal.setSide("miso soup");
    }

    public Meal getMeal() {
      return meal;
    }
}
