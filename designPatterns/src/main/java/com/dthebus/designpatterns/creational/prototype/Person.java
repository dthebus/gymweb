/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.creational.prototype;

/**
 *
 * @author darren
 */
public class Person implements Prototype{
    
    String name;
    
    public Person (String name){
        this.name = name;
    }

    @Override
    public Prototype doclone() {
      return new Person(name); 
    }

   
    public String getName() {
        return  name;
    }
    
}
