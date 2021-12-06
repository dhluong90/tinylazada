package com.luongdinh.productservice.dto;

import java.util.Objects;

import com.luongdinh.productservice.entity.ProductCategory;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Data
public class ProductCategoryRequestDto {
    private String name;

    public static ProductCategory toProductCategory(ProductCategoryRequestDto productCategoryRequestDto) {
        if (Objects.isNull(productCategoryRequestDto))
            return null;
        return new ModelMapper().map(productCategoryRequestDto, ProductCategory.class);
    }
}
