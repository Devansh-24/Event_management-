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

import com.example.Entity.Vendor;
import com.example.repository.VendorRepository;

@Controller
public class vendorLoginController {
    
    @Autowired
    private VendorRepository vendorRepository;

    
    @GetMapping("/vendorregister")
    public String showRegistrationForm(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "VendorRegistration";
    }
    

    @PostMapping("/vendorregister")
    public String registerCustomer (@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result,HttpSession session) {
        

        if (result.hasErrors()) {
            return "VendorRegistration";
        }

        if (!vendor.getVendorPass().equals(vendor.getVendorConfirmPass())) {
            result.rejectValue("vendorConfirmPass", "error.vendor", "Password and Confirm Password do not match.");
            session.setAttribute("msg", "Password Doesn't match");
            
            return "VendorRegistration";
        }

    else{

        vendorRepository.save(vendor);

        return "redirect:/VendorLogin";
    }
    }


    @PostMapping("/vendorlogin12")
    public String loginVendor(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "VendorLogin";
        }

        Vendor vendorFromDb = vendorRepository.findByVendorEmailAndVendorPass(vendor.getVendorEmail(), vendor.getVendorPass());

        if (vendorFromDb == null) {
            result.rejectValue("vendorEmail", "error.vendor", "Invalid Email or Password.");
            return "VendorLogin";
        }

        session.setAttribute("loggedInVendor", vendorFromDb);

        return "redirect:/home";
    }

    @GetMapping("/vendordashboard")
    public String showDashboard(HttpSession session) {
        Vendor loggedInVendor = (Vendor) session.getAttribute("loggedInVendor");

        if (loggedInVendor == null) {
            return "redirect:/login";
        }

        return "dashboard";
    }

    @GetMapping("/vendorlogout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/UserLogin";
    }


}
