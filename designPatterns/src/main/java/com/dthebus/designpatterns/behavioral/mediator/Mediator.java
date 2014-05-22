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
public class Mediator {
    Buyer swedishBuyer;
    Buyer frenchBuyer;
    AmericanSeller americanSeller;
    DollarConverter dollarConverter;
    
    public Mediator(){}
    
    public void registerSwedishBuyer(SwedishBuyer swedishBuyer)
    {
        this.swedishBuyer = swedishBuyer;
    }
    public void registerFrenchBuyer(FrenchBuyer frenchBuyer){
    this.frenchBuyer = frenchBuyer;
    }
    
     public void registerAmericanSeller(AmericanSeller americanSeller){
    this.frenchBuyer = frenchBuyer;
    }
      public void registerDollarConverter(DollarConverter dollarConverter){
    this.frenchBuyer = frenchBuyer;
    }
      public boolean placeBid(float bid, String unitOfCurrency){
          float dollarAmount = dollarConverter.convertCurrencyToDollars(bid, unitOfCurrency);
          return americanSeller.isBidAccepted(dollarAmount);
      }
}
