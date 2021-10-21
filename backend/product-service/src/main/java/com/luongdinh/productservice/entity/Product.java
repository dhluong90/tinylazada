package com.luongdinh.productservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Product extends GenericEntity {

    @Id
    private Long id;
    @NotNull
    private String name;
    @OneToMany
    private Mall mall;
    @OneToMany
    private List<ProductReview> productReview; 
    private Double price;
    private boolean cashDelivery;
    private String brand;
    private List<Image> images;
    private Integer quantity;
    private ProductCategory productCategory;
}
