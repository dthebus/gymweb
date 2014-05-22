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
public class MealInvoker {
    Command command;
    
    public MealInvoker(Command command){
        this.command= command;
    }
    
    public void setCommand(Command command){
        this.command= command;
    }
    public String invoke(){
       return command.execute();
    }
}
