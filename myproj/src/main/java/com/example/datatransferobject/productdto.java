package com.example.datatransferobject;

import lombok.Data;

@Data
public class productdto {
    private Long Id;
    private String productName;
    private int category_id;
    private String companyName;
    private double price;
    private String Quantity;
    private String description;
    private String imageName;
    
}
