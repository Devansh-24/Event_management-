package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Entity.category;
import com.example.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
    public void addCategory(category category){
         categoryRepository.save(category);
    }
   //List of all the categories will be returened 
    public List<category> getAllCategory(){
        return categoryRepository.findAll();
    }
   
    public void deleteCatById(int id){
        categoryRepository.deleteById(id);
    }
    // optional be then we can check if category is present or not
    public Optional<category> getCatById(int id){
      return  categoryRepository.findById(id);
    }
}
