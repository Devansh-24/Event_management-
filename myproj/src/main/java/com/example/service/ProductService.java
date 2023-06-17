package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.vendorProduct;
import com.example.repository.vendorProductRepository;

@Service
public class ProductService {
    
    @Autowired
    vendorProductRepository vendorProductRepository;

    public List<vendorProduct> getAllProduct(){
        return vendorProductRepository.findAll();
}
// add items method
public void addvendorProduct(vendorProduct vendorProduct){
    vendorProductRepository.save(vendorProduct);
}

// delete the items
public String deletevendorproductById(Long Id){
    vendorProductRepository.deleteById(Id);
       return "Deleted successfully";
}

// optional will be returned here

public Optional<vendorProduct> getvendorProductById(Long Id){
    return vendorProductRepository.findById(Id);
}

// to sort items according to services lets write a method find allby services

public List<vendorProduct> getAllvendorProductBycategoryId(int id){
    return vendorProductRepository.findAllBycategory_id(id);

}
}