package com.example.spring_boilerplate_stater.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;


@EntityScan
@AllArgsConstructor
@NoArgsConstructor
public class User {
   @Id
   @Generated 
    private String title;
    private String price;
    private String imageUrl;
    private String productUrl;
    private String countProduct;
    private String shopName;
    private String placeShop;
}
