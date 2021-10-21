package com.luongdinh.productservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ProductReview extends GenericEntity {
    
    @Id
    private Long id;
    private Integer numberOfStar;
    private String comment;
    @ManyToOne
    Product product;
}
