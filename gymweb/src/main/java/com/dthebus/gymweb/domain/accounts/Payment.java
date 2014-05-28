/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.domain.accounts;

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
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private int memberID;
    private double amount;
     
     private Payment(Builder builder) {
        id= builder.id;
        memberID = builder.memberID;
        amount = builder.amount;
       }
     private Payment(){}
     
     public static class Builder {

        private Long id;
        private int memberID;
        private double amount;
        public Builder(int value) {
            this.memberID = value;
           
        }
        
       
        public Builder entity(Payment entity){
            id = entity.getpaymentId();
            memberID = entity.getmemberID();
            amount = entity.getAmount();
            return this;
            
        }
        public Builder amount(double value) {
            amount = value;
            return this;
        }
        public Payment build(){
            return new Payment(this);
        }

    }

    public int getmemberID() {
        return memberID;
    }
    public Long getpaymentId() {
        return id;
    }
    public double getAmount(){
    return amount;
    }
   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
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
