package com.luongdinh.identityserver.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
public class GenericEntity {

    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
    @CreatedDate
    private Long createdDate;
    @LastModifiedDate
    private Date modifiedDate;
    @ColumnDefault("false")
    private boolean deleted = false;

}