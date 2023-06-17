package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.CustomerRepository;

@Service
public class customerServices {
    
    @Autowired
	private CustomerRepository customerRepository;

    public boolean checkcustEmail(String custEmail) {

		return customerRepository.existsByCustEmail(custEmail);
	}
}
