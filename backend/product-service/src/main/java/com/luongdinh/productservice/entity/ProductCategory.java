package com.luongdinh.productservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi.generic;

import lombok.Data;

@Data
@Entity
public class ProductCategory extends GenericEntity{
    @Id
    private Long id;
    private String name;
}
