package com.luongdinh.productservice.service;

public interface ProductService {
    
    public List<ProductListResponse.Product> getProductsByPage(Pageable pageable); 
}
