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
public class AnimalFactory {
    
    private static AnimalFactory animal = null;
    public static AnimalFactory getInstance()
    {
        if(animal==null)
            animal= new AnimalFactory();
        return animal;
    }
    public Animal getAnimal(String type)
    {
        if("canine".equals(type))
            return new Dog();
        else
            return new Cat();
                    
    }
}
