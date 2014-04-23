/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author darren
 */
@Entity
public class FullMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

     
     private FullMember(Builder builder) {
        id= builder.id;
        name = builder.name;
       
       }
     private FullMember(){}
     
     public static class Builder {

        private Long id;
        private String name;
        
        public Builder(Long id) {
            this.id = id;
        }
       


        public Builder name(String value) {
            name = value;
            return this;
        }

       
        public Builder person(FullMember person){
            id = person.getId();
            name = person.getName();
            
            return this;
            
        }
        
        public FullMember build(){
            return new FullMember(this);
        }

    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
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
        if (!(object instanceof FullMember)) {
            return false;
        }
        FullMember other = (FullMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dthebus.gymweb.domain.FullMember[ id=" + id + " ]";
    }
    
}
