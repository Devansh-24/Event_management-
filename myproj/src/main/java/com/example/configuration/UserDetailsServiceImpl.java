// package com.example.configuration;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.example.Entity.Customers;
// import com.example.repository.UserRepository;



// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {

// 	@Autowired
// 	private UserRepository userRepo;

// 	@Override
// 	public UserDetails loadUserByUsername(String custEmail) throws UsernameNotFoundException {

//             Customers   user = userRepo.findByCustEmail(custEmail);

// 		if (user != null) {
// 			return new CustomUserDetails(user);
// 		}

// 		throw new UsernameNotFoundException("user not available");
// 	}
// }