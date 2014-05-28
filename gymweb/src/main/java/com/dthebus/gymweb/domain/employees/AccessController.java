/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.domain.employees;

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
public class AccessController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String name;
    private String surname;
    private double salary;
     
     private AccessController(Builder builder) {
        id= builder.id;
        name = builder.name;
        surname = builder.surname;
        salary = builder.salary;
       }
     private AccessController(){}
     
     public static class Builder {

        private Long id;
        private String name;
        private String surname;
        private double salary;
        public Builder(String value) {
            this.name = value;
           
        }
        
       
        public Builder person(AccessController person){
            id = person.getId();
            name = person.getName();
            surname = person.getSurname();
            salary =person.getSalary();
            return this;
            
        }
        public Builder surname(String value) {
            surname = value;
            return this;
        }
        public Builder salary(double  sal){
            salary= sal;
            return this;
        }
        public AccessController build(){
            return new AccessController(this);
        }

    }
public double getSalary(){
    return salary;
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
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessController)) {
            return false;
        }
        AccessController other = (AccessController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dthebus.gymweb.test.repository.AccessController[ id=" + id + " ]";
    }
    
}
