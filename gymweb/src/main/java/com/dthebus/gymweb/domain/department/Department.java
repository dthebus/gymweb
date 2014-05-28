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
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String name;
    private int managerID;
     
     private Department(Builder builder) {
        id= builder.id;
        name = builder.name;
        managerID = builder.managerID;
       }
     private Department(){}
     
     public static class Builder {

        private Long id;
        private String name;
        private int managerID;
        public Builder(String value) {
            this.name = value;
           
        }
        
       
        public Builder entity(Department entity){
            id = entity.getId();
            name = entity.getName();
            managerID = entity.getManagerID();
            return this;
            
        }
        public Builder managerID(int value) {
            managerID = value;
            return this;
        }
        public Department build(){
            return new Department(this);
        }

    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public int getManagerID(){
    return managerID;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
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
