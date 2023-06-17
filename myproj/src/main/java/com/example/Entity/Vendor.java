package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vendor")
public class Vendor {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long v_id;

    @Column(nullable = false)
    private String vendorName;

    @Column(nullable = false, unique = true)
    private String vendorEmail;

    private String vendorMob;

    private String vendorPass;

    @Transient
    private String vendorConfirmPass;

    public Long getV_id() {
        return v_id;
    }

    public void setV_id(Long v_id) {
        this.v_id = v_id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorMob() {
        return vendorMob;
    }

    public void setVendorMob(String vendorMob) {
        this.vendorMob = vendorMob;
    }

    public String getVendorPass() {
        return vendorPass;
    }

    public void setVendorPass(String vendorPass) {
        this.vendorPass = vendorPass;
    }

    public String getVendorConfirmPass() {
        return vendorConfirmPass;
    }

    public void setVendorConfirmPass(String vendorConfirmPass) {
        this.vendorConfirmPass = vendorConfirmPass;
    }

    public Vendor(Long v_id, String vendorName, String vendorEmail, String vendorMob, String vendorPass,
            String vendorConfirmPass) {
        this.v_id = v_id;
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.vendorMob = vendorMob;
        this.vendorPass = vendorPass;
        this.vendorConfirmPass = vendorConfirmPass;
    }

    public Vendor() {
    }

    


}
