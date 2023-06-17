package com.example.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.exceptions.AlreadyInitializedException;
import java.security.Principal;

import com.example.Entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.customerServices;

@Controller
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private customerServices custServ;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration";
    }

    @PostMapping("/register")
    public String registerCustomer (@Valid @ModelAttribute("customer") Customer customer, BindingResult result,HttpSession session) {
        

        if (result.hasErrors()) {
            return "registration";
        }

        if (!customer.getCustPass().equals(customer.getCustConfirmPass())) {
            result.rejectValue("custConfirmPass", "error.customer", "Password and Confirm Password do not match.");
            session.setAttribute("msg", "Password Doesn't match");
            
            return "UserRegistration";
        }

    else{

        customerRepository.save(customer);

        return "redirect:/UserLogin";
    }
    }


    
    // @GetMapping("/login")
    // public String showLoginForm(Model model) {
    //     model.addAttribute("customer", new Customer());
    //     return "login";
    // }

    @PostMapping("/login12")
    public String loginCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "UserLogin";
        }

        Customer customerFromDb = customerRepository.findByCustEmailAndCustPass(customer.getCustEmail(), customer.getCustPass());

        if (customerFromDb == null) {
            result.rejectValue("custEmail", "error.customer", "Invalid Email or Password.");
            return "UserLogin";
        }

        session.setAttribute("loggedInCustomer", customerFromDb);

        return "redirect:/home";
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session) {
        Customer loggedInCustomer = (Customer) session.getAttribute("loggedInCustomer");

        if (loggedInCustomer == null) {
            return "redirect:/login";
        }

        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


    
}
