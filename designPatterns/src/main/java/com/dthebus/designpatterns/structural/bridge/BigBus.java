/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.structural.bridge;

/**
 *
 * @author darren
 */
public class BigBus extends Vehicle{

    public BigBus(Engine engine){
        this.weightInKilos=3000;
        this.engine= engine;
    }
    @Override
    public String drive() {
        int horsepower = engine.go();
        return reportOnSpedd(horsepower);
    }
    
}
