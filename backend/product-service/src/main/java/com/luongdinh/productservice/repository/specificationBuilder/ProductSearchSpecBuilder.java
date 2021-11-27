package com.luongdinh.productservice.repository.specificationBuilder;

import java.util.Collections;

import com.luongdinh.productservice.dto.ProductSearchParamDto;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.entity.Product_;

import org.springframework.data.jpa.domain.Specification;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductSearchSpecBuilder {

    public static Specification<Product> getProductSearchSpec(ProductSearchParamDto productSearchParamDto) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.in(root.get(Product_.ID))
                    .value(productSearchParamDto.getIds().orElse(Collections.EMPTY_LIST));
        };
    }

}
