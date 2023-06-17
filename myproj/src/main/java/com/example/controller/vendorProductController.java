package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Entity.vendorProduct;
import com.example.datatransferobject.productdto;

import com.fasterxml.jackson.core.sym.Name;
import com.example.service.CategoryService;
import com.example.service.ProductService;

// @RestController
@Controller
public class vendorProductController {
    //  to save our images to static folder
      public String uploadDir=  "C:/Users/cheta/Desktop/mangalmurti/src/main/resources/static/image";
    @Autowired
    ProductService vendorProductService;
    @Autowired
   CategoryService categoryService; 
  

    @GetMapping("/vendor/products")
    public String products(Model model){
        model.addAttribute("products", vendorProductService.getAllProduct());
        return "vendorProduct";
    }
    @GetMapping("/vendor/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productdto", new productdto());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "vendorProductadd";
    }

    // to save the data of product
  @PostMapping("/vendor/products/add")
//   wheneever an image comesyou have to use multipart
  public String vendorproductAddPost(@ModelAttribute("productdto") productdto productdto,
                          @RequestParam("productImage")MultipartFile file,
                          @RequestParam ("imgName")String imgName) throws IOException{
                        //  fole handling throws ioexception
                            // the object that we brought is product dto and we want to save vwndor product object so lets convert it

                    vendorProduct vitem=new vendorProduct();
                    vitem.setId(productdto.getId());
                    vitem.setProductName(productdto.getProductName());
                    // try {
                    //     vitem.setCategory(categoryService.getCatById(productdto.getCategory_id()).get());
                    // } catch (NoSuchElementException e) {
                    //     model.addAttribute("error", "Invalid category ID");
                    //     model.addAttribute("categories", categoryService.getAllCategory());
                    //     return "vendorProductadd";
                    // }
                    vitem.setCategory(categoryService.getCatById(productdto.getCategory_id()).get());
                    vitem.setCompanyName(productdto.getCompanyName()); 
                    vitem.setPrice(productdto.getPrice());
                    vitem.setQuantity(productdto.getQuantity());
                    vitem.setDescription(productdto.getDescription());
                     // now when we update item we cannot send image compulsary so we have to do some tikdam
                      // UUID=Universal unique id
                               String imageUUID;
                               if(!file.isEmpty())
                               {
                                imageUUID =file.getOriginalFilename();
                                Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
                                Files.write(fileNameAndPath,file.getBytes());
                                // since files are in byte formate we are telling to write aname of file in bytecode
                                // we have default created a path in line 63
                               }
                               else{
                                imageUUID =imgName;
                               }
                            vitem.setImageName(imageUUID);
                            vendorProductService.addvendorProduct(vitem);
 
                    return "redirect:/vendor/products"; 
                          }  
                        
//           //now we need to convert vendorItemdto to vendorItem so lets do it
//         //   instead that you can use map or bulider which is advance concept

//             //  to send something different to browser use requestparam
@GetMapping("/vendor/products/delete/{id}")
public String deletevendorProduct(@PathVariable Long Id){
  vendorProductService.deletevendorproductById(Id);
  return "redirect:/vendor/vendorProduct";
}
  
  @GetMapping("/vendor/products/update/{id}")
  public String updatevendorProductget(@PathVariable Long id,Model model){
//     // to reverse the upper method
    vendorProduct vitem= vendorProductService.getvendorProductById(id).get();
    productdto vdto=new productdto();
    vdto.setId(vdto.getId());
    vdto.setProductName(vitem.getProductName());
    vdto.setCompanyName(vitem.getCompanyName());
    vdto.setCategory_id((vitem.getCategory().getId()));  
    vdto.setPrice(vitem.getPrice());
    vdto.setQuantity(vitem.getQuantity());
    vdto.setDescription(vitem.getDescription());
    vdto.setImageName(vitem.getImageName());

    model.addAttribute("categories",categoryService.getAllCategory());
    model.addAttribute("productdto", vdto);  

    return "vendoProducttemadd";

  }
}
