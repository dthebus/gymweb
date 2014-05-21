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
public class TemperatureObjectReporter implements TemperatureInfo{
CelciusReporter celciusReporter;
public TemperatureObjectReporter(){
    celciusReporter = new CelciusReporter();
}
    @Override
    public double getTemperatureInF() {
       return cToF(celciusReporter.getTemperature());
    }

    @Override
    public void setTemperatureInf(double temperatureInF) {
       celciusReporter.setTemperature(fToc(temperatureInF));
    }

    @Override
    public double getTemperatureInC() {
      return celciusReporter.getTemperature();
    }

    @Override
    public void setTemperatureInC(double temperatureInC) {
    celciusReporter.setTemperature(temperatureInC);
    }
     private double fToc(double f){
        return((f-32)* 5/9);
    }
    private double cToF(double c){
        return((c*9/5)+32 );
    }
}
