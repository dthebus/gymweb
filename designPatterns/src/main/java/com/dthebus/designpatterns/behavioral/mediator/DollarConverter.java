/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.mediator;

/**
 *
 * @author darren
 */
public class DollarConverter {
    Mediator mediator;
    public static final float dollar_unit = 1.0f;
    public static final float euro_unit = 0.7f;
    public static final float krona_unit = 0.8f;
    
    public DollarConverter(Mediator mediator){
        this.mediator= mediator;
        mediator.registerDollarConverter(this);
    }
    private float convertEurosToDollars(float euros){
        float dollars = euros *(dollar_unit / euro_unit);
        return dollars;
    }
    
    private float convertKronorToDollars(float kronor){
        float dollars = kronor *(dollar_unit / krona_unit);
        return dollars;
    }
    public float convertCurrencyToDollars(float amount, String unitOfCurrency){
        if("krona".equalsIgnoreCase(unitOfCurrency)){
            return convertKronorToDollars(amount);
        }
        else
            return convertEurosToDollars(amount);
    }
}
