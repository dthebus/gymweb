/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.structural.facade;

/**
 *
 * @author darren
 */
public class Class3 {
    public int cube3( Class1 class1, Class2 class2, int x){
    return class1.cube(x) * class2.cube2(class1, x);
}
}
