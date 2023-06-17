// package com.example.service;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.Entity.Customers;
// import com.example.repository.UserRepository;


// @Service
// public class UserServiceImpl implements UserService {
//     @Autowired
// 	private UserRepository userRepo;

// 	@Autowired
// 	private BCryptPasswordEncoder passwordEncode;

// 	@Override
// 	public Customers createUser(Customers user) {

// 		user.setCustPass(passwordEncode.encode(user.getCustPass()));
// 		user.setRole("ROLE_USER");

// 		return userRepo.save(user);
// 	}

// 	@Override
// 	public boolean checkcustEmail(String custEmail) {

// 		return userRepo.existsByCustEmail(custEmail);
// 	}
// }