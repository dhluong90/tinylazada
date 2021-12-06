package com.luongdinh.productservice.controller;

import java.io.IOException;

import com.amazonaws.services.kafkaconnect.model.BadRequestException;
import com.luongdinh.productservice.dto.ImageCreationRequestDto;
import com.luongdinh.productservice.entity.Image;
import com.luongdinh.productservice.service.ImageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class ImageController {

    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    imageService.savePublicFile(multipartFile.getInputStream(), multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Image> uploadImage(@RequestBody ImageCreationRequestDto imageCreationRequestDto) {
        return null;
    }
}
