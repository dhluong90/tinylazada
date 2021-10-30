package com.luongdinh.productservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.websocket.server.PathParam;
import javax.ws.rs.core.MediaType;

import com.luongdinh.productservice.dto.ProductCategoryRequestDto;
import com.luongdinh.productservice.dto.ProductCategoryResponseDto;
import com.luongdinh.productservice.entity.ProductCategory;
import com.luongdinh.productservice.service.ProductCategoryService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("productcategories")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;
    private ModelMapper modelMapper;

    public ProductCategoryController(ProductCategoryService productCategoryService, ModelMapper modelMapper) {
        this.productCategoryService = productCategoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<ProductCategoryResponseDto>> getProductCategoryPage() {
        ModelMapper modelMapper = new ModelMapper();
        List<ProductCategoryResponseDto> prodCategory = StreamSupport
                .stream(this.productCategoryService.getAll().spliterator(), false)
                .map(i -> modelMapper.map(i, ProductCategoryResponseDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(prodCategory);
    }

    @GetMapping(value = "/{prodCategoryId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProductCategoryResponseDto> getProductCategory(@PathParam("prodCategoryId") Long id) {
        ModelMapper modelMapper = new ModelMapper();
        return ResponseEntity
                .ok(modelMapper.map(this.productCategoryService.get(id), ProductCategoryResponseDto.class));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProductCategoryResponseDto> save(ProductCategoryRequestDto productCategoryRequestDto) {
        ProductCategory proCat = this.productCategoryService
                .save(new ProductCategory(null, productCategoryRequestDto.getName()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(proCat, ProductCategoryResponseDto.class));
    }

    @PutMapping(value = "/{productCategoryId}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProductCategoryResponseDto> update(@PathParam("prodCategoryId") Long id,
            ProductCategoryRequestDto productCategoryRequestDto) {
        ProductCategory productCategory = this.productCategoryService
                .save(new ProductCategory(id, productCategoryRequestDto.getName()));
        return ResponseEntity.ok(modelMapper.map(productCategory, ProductCategoryResponseDto.class));
    }

    @DeleteMapping(value = "/{productCategoryId}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> delete(@PathParam("productCategoryId") Long id) {
        this.productCategoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
