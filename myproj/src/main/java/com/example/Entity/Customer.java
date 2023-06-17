package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "customer")
public class Customer {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String custName;

    @Column(nullable = false, unique = true)
    private String custEmail;

    private String custMob;

    private String custPass;

    @Transient
    private String custConfirmPass;


    

    public Customer() {
    }

    public Customer(Long id, String custName, String custEmail, String custMob, String custPass,
            String custConfirmPass) {
        this.id = id;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custMob = custMob;
        this.custPass = custPass;
        this.custConfirmPass = custConfirmPass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustMob() {
        return custMob;
    }

    public void setCustMob(String custMob) {
        this.custMob = custMob;
    }

    public String getCustPass() {
        return custPass;
    }

    public void setCustPass(String custPass) {
        this.custPass = custPass;
    }

    public String getCustConfirmPass() {
        return custConfirmPass;
    }

    public void setCustConfirmPass(String custConfirmPass) {
        this.custConfirmPass = custConfirmPass;
    }

    
}
