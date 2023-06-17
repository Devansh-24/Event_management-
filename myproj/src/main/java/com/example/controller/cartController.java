package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.vendorProduct;
import com.example.global.globaldata;
import com.example.service.ProductService;

@Controller
// @RestController
public class cartController {
    @Autowired
    ProductService vendorItemService;
    
    @GetMapping("/addToCart/{id}")
    public String addTocart(@PathVariable Long Id){
        // globaldata.cart.add(vendorItemService.getvendorItemById(Id).get());
        return "redorect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model){
        // basic get size method is used
        model.addAttribute("cartCount",globaldata.cart.size());
        model.addAttribute("total",globaldata.cart.stream().mapToDouble(vendorProduct::getPrice).sum());
        // map to double will take value and do double of it
        model.addAttribute("cart",globaldata.cart);
        return "cart";
    }
    
    @DeleteMapping("/cart/remooveItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        globaldata.cart.remove(index);
        return "redirect:/cart";
    }
    @GetMapping("/checkout")

    public String  checkOut(Model model){
        model.addAttribute("total",globaldata.cart.stream().mapToDouble(vendorProduct::getPrice).sum());
        return "checkout";
    }
}
