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
public class Sandwich implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String name;
    private double price;
     
     private Sandwich(Builder builder) {
        id= builder.id;
        name = builder.name;
        price = builder.price;
       }
     private Sandwich(){}
     
     public static class Builder {

        private Long id;
        private String name;
        private double price;
        public Builder(String value) {
            this.name = value;
           
        }
        
       
        public Builder entity(Sandwich entity){
            id = entity.getId();
            name = entity.getName();
            price = entity.getPrice();
            return this;
            
        }
        public Builder price(double value) {
            price = value;
            return this;
        }
        public Sandwich build(){
            return new Sandwich(this);
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sandwich)) {
            return false;
        }
        Sandwich other = (Sandwich) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dthebus.gymweb.domain.Sandwich[ id=" + id + " ]";
    }
    
}
