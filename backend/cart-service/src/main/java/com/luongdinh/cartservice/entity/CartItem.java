package com.luongdinh.cartservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.luongdinh.tinylazada.common.entity.GenericEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE cart_item SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CartItem extends GenericEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    private UserCart userCart;

}
