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
public class TemperatureClassReporter extends CelciusReporter implements TemperatureInfo{

    @Override
    public double getTemperatureInF() {
        return cToF(temperatureInC);
     }

    @Override
    public void setTemperatureInf(double temperatureInF) {
       this.temperatureInC= fToc(temperatureInF);
    }

    @Override
    public double getTemperatureInC() {
    return temperatureInC;
    }

    @Override
    public void setTemperatureInC(double temperatureInC) {
   this.temperatureInC = temperatureInC;
    }
    private double fToc(double f){
        return((f-32)* 5/9);
    }
    private double cToF(double c){
        return((c*9/5)+32 );
    }
}
