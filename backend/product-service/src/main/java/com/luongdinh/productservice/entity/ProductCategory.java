package com.luongdinh.productservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.luongdinh.tinylazada.common.entity.GenericEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@SQLDelete(sql = "UPDATE product_category SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Builder
public class ProductCategory extends GenericEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
