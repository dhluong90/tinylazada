package com.luongdinh.productservice.dto;

import java.util.Objects;

import com.luongdinh.productservice.entity.ProductReview;

import org.modelmapper.ModelMapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductReviewResponseDto {
    private Long id;
    private Integer numberOfStar;
    private String comment;

    public static ProductReviewResponseDto fromProductReview(ProductReview productReview) {
        if (Objects.isNull(productReview))
            return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productReview, ProductReviewResponseDto.class);
    }
}
