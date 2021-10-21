package com.luongdinh.productservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Image extends GenericEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    
}
