package com.luongdinh.productservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.luongdinh.productservice.entity.ProductReview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProductReviewResponseDtoTest {

    @Test
    public void testMapper() {
        ProductReview productReview = new ProductReview();
        productReview.setComment("test");
        productReview.setId(1L);
        productReview.setNumberOfStar(5);
        ProductReviewResponseDto productReviewResponseDto = ProductReviewResponseDto.fromProductReview(productReview);
        assertEquals("test", productReviewResponseDto.getComment());
        assertEquals(1L, productReviewResponseDto.getId());
        assertEquals(5, productReviewResponseDto.getNumberOfStar());
    }

}
