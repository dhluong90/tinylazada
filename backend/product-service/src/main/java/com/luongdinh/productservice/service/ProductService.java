package com.luongdinh.productservice.service;

import com.luong.tinylazada.common.dto.PageResponse;
import com.luongdinh.productservice.dto.ProductDetailRequestDto;
import com.luongdinh.productservice.dto.ProductListResponseDto;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.repository.ProductRepository;

import org.springframework.data.domain.PageRequest;

public interface ProductService extends CRUDService<Product, Long, ProductRepository> {

    public PageResponse<ProductListResponseDto> getProductsByPage(PageRequest pageable);

    public Product create(ProductDetailRequestDto productDetailRequestDto);

    public Product update(Long id, ProductDetailRequestDto productDetailRequestDto);
}
