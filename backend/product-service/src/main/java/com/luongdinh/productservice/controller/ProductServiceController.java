package com.luongdinh.productservice.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

import com.luongdinh.productservice.configuration.TinyLazadaProperties;
import com.luongdinh.productservice.dto.ProductListResponse;
import com.luongdinh.productservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public ResponseEntity<Page<ProductListResponse>> getProduct(@RequestParam @NotNull @Min(0) Integer page,
            @RequestParam @NotNull @Min(0) @Max(1000) Integer size) {
        return null;
    }

}
