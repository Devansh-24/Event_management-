package com.example.global;

import java.util.ArrayList;
import java.util.List;

import com.example.Entity.vendorProduct;

public class globaldata {
    public static List<vendorProduct>cart;
    // static bolck
    static{
   cart=new ArrayList<vendorProduct>();
    }
}
