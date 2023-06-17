package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class vendorProduct {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;
    private String productName;
    // private Long vendorId;
    // private Long venueId;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="category_id" ,referencedColumnName = "category_id")
    // categories is our services that admin is gonna select
    private category category;
    private String companyName;
    private double price;
    private String Quantity;
    private String description;
    private String imageName;

}
