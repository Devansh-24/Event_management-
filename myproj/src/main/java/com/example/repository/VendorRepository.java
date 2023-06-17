package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
    

    Vendor findByVendorEmail(String vendorEmail);

    Vendor findByVendorEmailAndVendorPass(String vendorEmail, String vendorPass);
}
