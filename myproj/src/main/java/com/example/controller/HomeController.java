package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.CategoryService;
import com.example.service.ProductService;

@Controller
// @RestController
public class HomeController {
    
    @Autowired
  CategoryService categoryService;;

    @Autowired
    ProductService vendorProductService;
  
    @GetMapping("/home")
    public String home(Model model){
        // /here index is our servicesitem page
return "index.html";
    }

    @GetMapping("/UserRegistration")
    public String UserRegistration(){

    return "UserRegistration.html";
    }

    @GetMapping("/UserLogin")
    public String UserLogin(){

    return "UserLogin.html";
    }



    @GetMapping("/Gallery")
    public String Gallery(){
        // /here index is our servicesitem page
return "Gallery.html";
    }
    @GetMapping("/Aboutus")
    public String abt(){
        // /here index is our servicesitem page
return "Aboutus.html";
    }
    @GetMapping("/packages")
    public String pack(){
        // /here index is our servicesitem page
return "packages.html";
    }
    @GetMapping("/Reviews")
    public String revi(){
        // /here index is our servicesitem page
return "Reviews.html";
    }

    @GetMapping("/venues")
    public String ven(){
        // /here index is our servicesitem page
return "venue.html";
    }
 @GetMapping("/contact")
    public String con(){
        // /here index is our servicesitem page
return "contact.html";
    }
    @GetMapping("/services")
    public String ser(){
        // /here index is our servicesitem page
return "services.html";
    }

    @GetMapping("/VendorLogin")
    public String vl(){
        // /here index is our servicesitem page
return "VendorLogin.html";
    }
    @GetMapping("/Userlogin")
    public String log(){
        // /here index is our servicesitem page
return "UserLogin.html";
    }
    @GetMapping("/VendorRegistration")
    public String vendlog(){
        // /here index is our servicesitem page
return "VendorRegistration.html";
    }
   
     @GetMapping("/shop")
     public String shop(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",vendorProductService.getAllProduct());
        return "shop";
     }


     @GetMapping("/shop/category/{id}")
     public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",vendorProductService.getAllvendorProductBycategoryId(id));
        return "shop";
     }

     @GetMapping("/shop/viewProducts/{id}")
     public String getvendor(Model model, @PathVariable Long Id){
        model.addAttribute("products",vendorProductService.getvendorProductById(Id).get());
        return "viewProduct";
     }

     }
