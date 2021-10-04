package com.luongdinh.productservice.controller;

import com.luongdinh.productservice.configuration.TinyLazadaProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

    @Autowired
    private TinyLazadaProperties tinyLazadaProperties; 

    @GetMapping("/test")
    public String getConfiguration() {
        return String.valueOf(this.tinyLazadaProperties.getTest());
    }
    
}
