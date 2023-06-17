package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.vendorProduct;

@Repository
public interface vendorProductRepository extends JpaRepository<vendorProduct,Long> {
    List<vendorProduct> findAllBycategory_id(int id);
}
