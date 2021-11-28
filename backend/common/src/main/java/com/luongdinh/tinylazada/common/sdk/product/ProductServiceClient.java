package com.luongdinh.tinylazada.common.sdk.product;

import java.util.List;

import com.luongdinh.tinylazada.common.dto.PageResponse;
import com.luongdinh.tinylazada.common.sdk.product.response.ProductListResponseDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/products")
    PageResponse<ProductListResponseDto> fetchProductListResponse(@RequestParam int page, @RequestParam int size,
            @RequestParam List<Long> ids);
}
