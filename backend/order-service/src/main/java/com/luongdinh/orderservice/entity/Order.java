package com.luongdinh.orderservice.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.luongdinh.orderservice.enumtype.OrderStatus;
import com.luongdinh.tinylazada.common.entity.GenericEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;

@Entity
@Where(clause = "deleted=false")
@SQLDelete(sql = "update order set deleted=true where id=?")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
public class Order extends GenericEntity {

    @Id
    private Long id;
    @Column(nullable = false)
    private BigDecimal totalAmount;
    private Long userId;
    @OneToMany
    private List<OrderItem> orderItem;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Timestamp orderedTime;
}
