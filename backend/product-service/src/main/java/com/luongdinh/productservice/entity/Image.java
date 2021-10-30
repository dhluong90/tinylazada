package com.luongdinh.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
@SQLDelete(sql = "UPDATE image SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Image extends GenericEntity {

    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    private String url;

    public Image(String url) {
        this.url = url;
    }
}
