/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.command;

/**
 *
 * @author darren
 */
public class DinnerCommand implements Command{
     Dinner dinner;
    public DinnerCommand(Dinner dinner){
        this.dinner = dinner;
    }
    @Override
    public String execute() {
     return dinner.makeDinner();
    }
}
