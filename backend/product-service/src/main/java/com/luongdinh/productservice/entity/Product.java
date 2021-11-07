package com.luongdinh.productservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.luong.tinylazada.common.entity.GenericEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Product extends GenericEntity {

    @Id
    private Long id;
    @NotNull
    private String name;
    @ManyToOne
    private Mall mall;
    @OneToMany
    private List<ProductReview> productReview;
    private Double price;
    private boolean cashDelivery;
    private String brand;
    @OneToMany
    private List<Image> images;
    private Integer quantity;
    @ManyToOne
    private ProductCategory productCategory;
}
