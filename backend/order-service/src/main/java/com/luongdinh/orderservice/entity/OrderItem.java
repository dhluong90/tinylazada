package com.luongdinh.orderservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.amazonaws.services.outposts.model.OrderStatus;
import com.luongdinh.tinylazada.common.entity.GenericEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.actuate.audit.listener.AuditListener;

import lombok.Data;

@Entity
@Where(clause = "deleted = false")
@SQLDelete(sql = "update order_item set deleted = true where id =? ")
@EntityListeners(AuditListener.class)
@Data
public class OrderItem extends GenericEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    @ManyToOne
    private Order order;

}
