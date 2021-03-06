package com.luongdinh.productservice.controller;

import com.luongdinh.productservice.service.ProductService;
import com.luongdinh.tinylazada.common.configuration.TinyLazadaProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductServiceController {

    private TinyLazadaProperties tinyLazadaProperties;

    public ProductServiceController(TinyLazadaProperties tinyLazadaProperties, ProductService productService) {
        this.tinyLazadaProperties = tinyLazadaProperties;
    }

    @GetMapping("/test")
    public String getConfiguration() {
        return String.valueOf(this.tinyLazadaProperties.getTest());
    }

}
