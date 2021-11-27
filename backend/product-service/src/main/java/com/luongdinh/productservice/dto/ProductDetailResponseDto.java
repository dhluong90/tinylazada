package com.luongdinh.productservice.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.luongdinh.productservice.entity.Image;
import com.luongdinh.productservice.entity.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductDetailResponseDto {
    private Long id;
    private String name;
    private MallResponseDto mall;
    private List<ProductReviewResponseDto> productReview;
    private BigDecimal price;
    private boolean cashDelivery;
    private String brand;
    private List<Image> images;
    private Integer quantity;
    private ProductCategoryResponseDto productCategory;

    public static ProductDetailResponseDto fromProduct(Product product) {
        if (Objects.isNull(product))
            return null;
        return ProductDetailResponseDto.builder().name(product.getName())
                .mall(MallResponseDto.fromMall(product.getMall())).price(product.getPrice())
                .cashDelivery(product.isCashDelivery()).brand(product.getBrand()).images(product.getImages())
                .quantity(product.getQuantity())
                .productCategory(ProductCategoryResponseDto.fromProductCategory(product.getProductCategory())).build();
    }
}
