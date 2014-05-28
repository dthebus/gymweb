/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.domain.department;

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
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String name;
    private String products;
     
     private Supplier(Builder builder) {
        id= builder.id;
        name = builder.name;
        products = builder.products;
       }
     private Supplier(){}
     
     public static class Builder {

        private Long id;
        private String name;
        private String products;
        public Builder(String value) {
            this.name = value;
           
        }
        
       
        public Builder entity(Supplier entity){
            id = entity.getId();
            name = entity.getName();
            products = entity.getProducts();
            return this;
            
        }
        public Builder products(String value) {
            products = value;
            return this;
        }
        public Supplier build(){
            return new Supplier(this);
        }

    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public String getProducts(){
    return products;
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dthebus.gymweb.domain.ProteinShake[ id=" + id + " ]";
    }
    
}
