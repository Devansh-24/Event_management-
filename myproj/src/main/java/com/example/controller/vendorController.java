package com.example.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.category;
import com.example.service.CategoryService;

// Since vendor will also have a dashboard where he will manage his products and details 
// lets write a contoller for vendors management
@Controller
public class vendorController {
   @Autowired
   CategoryService categoryService;
    // let us get oudr vendor home page using get method


    @GetMapping("/vendor")
    public  String vendorHome() {
        return "vendorHome";
    }
    // let us get categories that is our services like catrs,artist from admin
    //this method will take you to categories page 
    @GetMapping("/vendor/categories")
    public String  getCat(Model model) {
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    // here the category object have come from view page 
    @GetMapping("/vendor/categories/add")
    // let us send an empty object
    public String  getCatAdd(Model model) {
        model.addAttribute("category",new category());
        return "categoriesAdd";
    }
    // write a method so that vendor will add the services like brefast,full meal etc
    @PostMapping("/vendor/categories/add")
    // let us send an empty object
    public String  postCatAdd(@ModelAttribute("category") category category) {
       categoryService.addCategory(category);
       return "redirect:/vendor/categories";
    }
    
    // let us make a vendor Item section here and write methods
    // to delete
    @GetMapping("/vendor/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
      categoryService.deleteCatById(id);
      return "redirect:/vendor/categories";
    }

    // to update the categories in vendor page
    @GetMapping("/vendor/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
     Optional<category> cat=categoryService.getCatById(id);
     if(cat.isPresent()){
        model.addAttribute("category", cat.get());
        return "categoriesAdd";
     }
     else

        return "404-not found";
    }
    @GetMapping("/error")
    public String error(){
        return "404-not found";
    }
}
