package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.repository.AdminRepository;

@Service
public class AdminServices {
    
        @Autowired
        AdminRepository adminRepository;


        public Admin findByUsername(String username) {
            return adminRepository.findByUsername(username);
        }
    
        public boolean validateAdmin(String username, String password) {
            Admin admin = findByUsername(username);
            if (admin != null && admin.getPassword().equals(password)) {
                return true;
            }
            return false;   
        }
    }
    


