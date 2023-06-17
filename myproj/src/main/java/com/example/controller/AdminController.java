package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.repository.vendorProductRepository;
import com.example.service.AdminServices;



@Controller
public class AdminController {
    private final AdminServices adminService;

    // @Autowired
    // v_ServiceRepository v_ServiceRepository;
   
    // @Autowired
    // v_ServicessService vs;
 
@Autowired
vendorProductRepository vemd;
    @Autowired
    public AdminController(AdminServices adminService) {
        this.adminService = adminService;
    }

    // to login to dashboard
    @GetMapping("/admin/login")
    public String showLoginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin-login";
    }


    @PostMapping("/admin/login")
    public String submitLoginForm(@ModelAttribute("admin") Admin admin, Model model) {
        if (adminService.validateAdmin(admin.getUsername(), admin.getPassword())) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin-login";
        }
        
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard() {
        return "admin-dashboard";
    }

    // @GetMapping("/admin")
    // public String admin(Model model) {
    //     model.addAttribute("services", v_ServiceRepository.findAll());
    //     // model.addAttribute("venues", venueRepository.findAll());
    //     model.addAttribute("newService", new v_Services());
    //     // model.addAttribute("newVenue", new Venue());
    //     return "admin";
    // }

   
    
}
