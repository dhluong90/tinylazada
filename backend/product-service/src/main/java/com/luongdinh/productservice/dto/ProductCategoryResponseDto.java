package com.luongdinh.productservice.dto;

import java.util.Objects;

import com.luongdinh.productservice.entity.ProductCategory;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Data
public class ProductCategoryResponseDto {

    private String id;
    private String name;

    public ProductCategory toProductCategory() {
        return new ModelMapper().map(this, ProductCategory.class);
    }

    public static ProductCategoryResponseDto fromProductCategory(ProductCategory productCategory) {
        if (Objects.isNull(productCategory))
            return null;
        return new ModelMapper().map(productCategory, ProductCategoryResponseDto.class);
    }
}
