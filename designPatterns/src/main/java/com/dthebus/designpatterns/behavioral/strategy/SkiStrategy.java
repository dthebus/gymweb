/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.strategy;

/**
 *
 * @author darren
 */
public class SkiStrategy implements Strategy{

    @Override
    public boolean checkTemperature(int temperatureInF) {
    if(temperatureInF<=32){
        return true;
    }
    else return false;
    }
    
}
