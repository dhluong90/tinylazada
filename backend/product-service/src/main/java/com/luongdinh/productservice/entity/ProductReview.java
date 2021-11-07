package com.luongdinh.productservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.luong.tinylazada.common.entity.GenericEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE product_review SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ProductReview extends GenericEntity {

    @Id
    private Long id;
    @Min(0)
    @Max(5)
    private Integer numberOfStar;
    @NotBlank
    private String comment;
    @ManyToOne
    Product product;
}
