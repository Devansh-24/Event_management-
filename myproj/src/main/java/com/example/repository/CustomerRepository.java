package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    Customer findByCustEmail(String custEmail);

    Customer findByCustEmailAndCustPass(String custEmail, String custPass);

    public boolean existsByCustEmail(String custemail);
}
