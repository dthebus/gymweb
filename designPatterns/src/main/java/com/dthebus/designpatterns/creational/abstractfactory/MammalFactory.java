/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.creational.abstractfactory;

import com.dthebus.designpatterns.creational.factorymethod.Animal;
import com.dthebus.designpatterns.creational.factorymethod.Cat;
import com.dthebus.designpatterns.creational.factorymethod.Dog;

/**
 *
 * @author darren
 */
class MammalFactory extends SpeciesFactory {

    @Override
    public Animal getAnimal(String type) {
         if("dog".equals(type))
             return new Dog();
         else 
             return new Cat();
    }

   
    
}
