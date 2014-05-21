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
public class Meal {
   private String drink;
   private String maincourse;
   private String side;
   
    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getMaincourse() {
        return maincourse;
    }

    public void setMaincourse(String maincourse) {
        this.maincourse = maincourse;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Meal{" + "drink=" + drink + ", maincourse=" + maincourse + ", side=" + side + '}';
    }
   
        
}
