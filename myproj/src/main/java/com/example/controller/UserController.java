// package com.example.controller;



// import java.security.Principal;

// import javax.servlet.http.HttpSession;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.Entity.Customers;


// @Controller
// @RequestMapping("/user")
// public class UserController {

// 	@Autowired
// 	private com.example.repository.UserRepository userRepo;

// 	@Autowired
// 	private BCryptPasswordEncoder passwordEncoder;


	


// 	@ModelAttribute
// 	private void userDetails(Model m, Principal p) {
// 		String custEmail = p.getName();
		
//         Customers user = userRepo.findByCustEmail(custEmail);

// 		m.addAttribute("user", user);

// 	}

// 	@GetMapping("/")
// 	public String home() {
// 		return "user/home";
// 	}

// 	@GetMapping("/changePass")
// 	public String loadChangePassword() {
// 		return "user/change_password";
// 	}

// 	@PostMapping("/updatePassword")
// 	public String changePassword(Principal p,@RequestParam("oldPass") String oldPass,
// 	@RequestParam("newPass") String newPass,HttpSession session)
// 	{

// 		String custEmail=p.getName();
// 		Customers loginUser=userRepo.findByCustEmail(custEmail);

// 		boolean f=passwordEncoder.matches(oldPass,loginUser.getCustPass());

// 		if(f){
// 			//System.out.println("old password is correct");
// 			loginUser.setCustPass(passwordEncoder.encode(newPass));
// 			Customers updatePasswordUser=userRepo.save(loginUser);
// 			if(updatePasswordUser!=null)
// 			{
//                 session.setAttribute("msg","Password Change successfully");
			
// 			}
// 			else{
// 				session.setAttribute("msg","Something went wrong");
			
// 			}
// 		}
// 		else
// 		{
// 			session.setAttribute("msg","OLD password incorrect");
			
// 			//System.out.println("please enter correct password");
// 		}

// 		return "redirect:/user/changePass";
// 	}

// }
