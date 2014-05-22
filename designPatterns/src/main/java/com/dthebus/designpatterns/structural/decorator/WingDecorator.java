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
public class WingDecorator extends AnimalDecorator{
    public WingDecorator(Animal animal){
        super(animal);
    }

    @Override
    public String describe() {
    return animal.describe()+ fly();
    }
    public String fly()
    {
        return " fly";}
}
