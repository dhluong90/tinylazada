package com.luong.tinylazada.common.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@MappedSuperclass
@Data
public class GenericEntity {

    @LastModifiedDate
    private Date updatedDate;
    @CreatedDate
    private Date createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
    private boolean deleted;
}
