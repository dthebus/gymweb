/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.designpatterns.behavioral.interpreter;

/**
 *
 * @author darren
 */
public class Context {
    private String input;
    private String output;
    
    public Context(String input){
        this.input = input;
        this.output="";
    }
    public String getInput(){
        return input;
    }
    public void setInput(String input){
        this.input= input;
    }
    public String getOutput()
    {
    return output;
    }
    public void setOutPut(String output){
        this.output= output;
    }
}
