package com.luongdinh.productservice.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.websocket.server.PathParam;
import javax.ws.rs.core.MediaType;

import com.luongdinh.productservice.dto.ProductDetailRequestDto;
import com.luongdinh.productservice.dto.ProductDetailResponseDto;
import com.luongdinh.productservice.dto.ProductListResponseDto;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.service.ProductService;
import com.luongdinh.tinylazada.common.dto.PageResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.lang.NonNull;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ModelMapper modelMapper;

    @Autowired
    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<PageResponse<ProductListResponseDto>> productList(
            @RequestParam(defaultValue = "0") @NonNull @Min(0) Integer page,
            @RequestParam(defaultValue = "100") @Max(1000) Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getProductsByPage(pageRequest));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProductDetailResponseDto> getProduct(@PathParam("id") Long productId) {
        Product product = productService.get(productId).orElseThrow();
        return ResponseEntity.ok(modelMapper.map(product, ProductDetailResponseDto.class));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProductDetailResponseDto> updateProduct(@PathParam("id") Long id,
            @RequestBody @Valid ProductDetailRequestDto productDetailRequestDto) {
        Product product = this.productService.update(id, productDetailRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductDetailResponseDto.fromProduct(product));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProductDetailResponseDto> createProduct(
            @RequestBody @Valid ProductDetailRequestDto productDetailRequestDto) {
        Product product = this.productService.create(productDetailRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductDetailResponseDto.fromProduct(product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathParam("id") Long id) {
        this.productService.delete(id);
        return ResponseEntity.ok().build();
    }

}
