package com.luongdinh.productservice.repository;

import java.util.Optional;

import com.luongdinh.productservice.entity.Image;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
    Optional<Image> findByUrl(String url);
}
