/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.structural.adapter;

/**
 *
 * @author darren
 */
public class CelciusReporter {
    double temperatureInC;
    
    public CelciusReporter(){}
    
    public double getTemperature(){
    return temperatureInC;
    }

    public void setTemperature(double temperatureInC) {
        this.temperatureInC = temperatureInC;
    }
    
}
