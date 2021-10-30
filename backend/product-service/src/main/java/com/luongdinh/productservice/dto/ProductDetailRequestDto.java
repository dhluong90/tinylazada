package com.luongdinh.productservice.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.luongdinh.productservice.entity.Image;
import com.luongdinh.productservice.entity.Mall;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.entity.ProductCategory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductDetailRequestDto {

    @NotBlank(message = "Product Name can't be blank")
    @NotNull(message = "Product Name can't be null")
    private String name;
    @NotBlank(message = "Product must be belong to 1 mall")
    private Long mallId;
    @NotNull(message = "Product must have price")
    private Double price;
    private boolean cashDelivery;
    @NotNull(message = "Product brand can't be null")
    @NotBlank(message = "Product brand can't be blank")
    private String brand;
    @NotEmpty(message = "Product must have at least one picture")
    @NotNull(message = "Product must have at least one picture")
    private List<Long> images;
    @NotNull(message = "Product must have quantity ")
    @Min(0)
    private Integer quantity;
    @NotNull(message = "Product must be belong to 1 category")
    private Long productCategory;

    public static ProductDetailRequestDto fromProduct(Product product) {
        if (Objects.isNull(product))
            return null;
        return ProductDetailRequestDto.builder().name(product.getName()).mallId(product.getMall().getId())
                .price(product.getPrice()).cashDelivery(product.isCashDelivery()).brand(product.getBrand())
                .images(product.getImages().stream().map(Image::getId).collect(Collectors.toList()))
                .quantity(product.getQuantity()).productCategory(product.getProductCategory().getId()).build();
    }

    public Product toProduct() {
        return Product.builder().brand(this.getBrand()).name(this.getName())
                .mall(Mall.builder().id(this.getMallId()).build())
                .images(this.images.stream().map(i -> Image.builder().id(i).build()).collect(Collectors.toList()))
                .quantity(this.getQuantity())
                .productCategory(ProductCategory.builder().id(this.getProductCategory()).build()).build();
    }
}
