package com.luongdinh.productservice.dto;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;

import com.luongdinh.productservice.entity.ProductReview;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;

import lombok.Data;

@Data
public class ProductListResponse {
    
    List<Product> products;

    @Data
    static public class Product {
        private Long id;
        private String productName;
        private String imgeUrl;
        private Double averageStar;
        private Long totalReview;

        static public Product fromProduct(com.luongdinh.productservice.entity.Product product) {
            Product shortProduct = new Product();
            shortProduct.setId(product.getId());
            shortProduct.setProductName(product.getName());
            IntSummaryStatistics intSummaryStatistics =  product.getProductReview().stream().mapToInt(ProductReview::getNumberOfStar).summaryStatistics();
            shortProduct.setAverageStar(intSummaryStatistics.getAverage());
            shortProduct.setTotalReview(intSummaryStatistics.getSum());
            shortProduct.setImgeUrl(product.getImages().get(0));
            return shortProduct;
        }
    }
}
