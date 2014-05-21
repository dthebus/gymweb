/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.creational.singleton;

/**
 *
 * @author darren
 */
public class SingletonExample {
    private static SingletonExample singletonExample = null;
    
    public static SingletonExample getInstance()
    {
     if(singletonExample == null){
         singletonExample = new SingletonExample();
     }
     return singletonExample;
    
    }
    
    public int getID()
    {
    return 1001;
    }
}
