/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.domain.members;

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
public class LimitedMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 private String name;
    private String surname;
    private int age; 
     private LimitedMember(Builder builder) {
        id= builder.id;
        name = builder.name;
        surname = builder.surname;
        age= builder.age;
       }
     private LimitedMember(){}
     
     public static class Builder {

        private Long id;
        private String name;
        private String surname;
        private int age;
        public Builder(String value) {
            this.name = value;
           
        }
        
       
        public Builder person(LimitedMember person){
            id = person.getId();
            name = person.getName();
            surname = person.getSurname();
            age= person.getAge();
            return this;
            
        }
        public Builder surname(String value) {
            surname = value;
            return this;
        }
        public Builder age(int age)
        {
            this.age = age;
            return this;
        }
        
        public LimitedMember build(){
            return new LimitedMember(this);
        }

    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public String getSurname(){
    return surname;
    }
   
    public int getAge(){
        return age;
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
        if (!(object instanceof LimitedMember)) {
            return false;
        }
        LimitedMember other = (LimitedMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dthebus.gymweb.domain.LimitedMember[ id=" + id + " ]";
    }
    
}
