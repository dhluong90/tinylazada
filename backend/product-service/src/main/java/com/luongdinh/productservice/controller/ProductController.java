package com.luongdinh.productservice.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.service.ProductService;
import com.netflix.discovery.converters.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.lang.NonNull;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<Page<Product>> productList(@RequestParam @NonNull @Min(0)  Integer page, @Max(1000) Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        productService.getProductsByPage(pageRequest);
        return null;
    }
    
}
