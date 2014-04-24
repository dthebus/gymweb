/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author darren
 */
@Entity
public class HealthShake implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String name;
    private double price;
     
     private HealthShake(Builder builder) {
        id= builder.id;
        name = builder.name;
        price = builder.price;
       }
     private HealthShake(){}
     
     public static class Builder {

        private Long id;
        private String name;
        private double price;
        public Builder(String value) {
            this.name = value;
           
        }
        
       
        public Builder entity(HealthShake entity){
            id = entity.getId();
            name = entity.getName();
            price = entity.getPrice();
            return this;
            
        }
        public Builder price(double value) {
            price = value;
            return this;
        }
        public HealthShake build(){
            return new HealthShake(this);
        }

    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public double getPrice(){
    return price;
    }
   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HealthShake)) {
            return false;
        }
        HealthShake other = (HealthShake) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dthebus.gymweb.domain.HealthShake[ id=" + id + " ]";
    }
    
}
