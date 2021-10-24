package com.luongdinh.productservice.controller;

import com.luongdinh.productservice.configuration.TinyLazadaProperties;
import com.luongdinh.productservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductServiceController {

    private TinyLazadaProperties tinyLazadaProperties;
    private ProductService productService;

    @Autowired
    public ProductServiceController(TinyLazadaProperties tinyLazadaProperties, ProductService productService){
       this.productService = productService;
       this.tinyLazadaProperties = tinyLazadaProperties;
    }

    @GetMapping("/test")
    public String getConfiguration() {
        return String.valueOf(this.tinyLazadaProperties.getTest());
    }

}
