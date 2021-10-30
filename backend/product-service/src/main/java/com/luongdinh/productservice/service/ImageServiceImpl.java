package com.luongdinh.productservice.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;

import com.amazonaws.util.Base64;
import com.luongdinh.productservice.configuration.TinyLazadaProperties;
import com.luongdinh.productservice.entity.Image;
import com.luongdinh.productservice.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends AbstractCRUDService<Image, Long, ImageRepository> implements ImageService {

    private ImageRepository imageRepository;
    private FileStoreService s3fFileStoreService;
    private TinyLazadaProperties tinyLazadaProperties;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, FileStoreService s3FileStoreService,
            TinyLazadaProperties tinyLazadaProperties) {
        this.imageRepository = imageRepository;
        this.s3fFileStoreService = s3FileStoreService;
        this.tinyLazadaProperties = tinyLazadaProperties;
    }

    @Override
    protected ImageRepository getEntityRepository() {
        return imageRepository;
    }

    @Override
    public Optional<Image> getImageByURl(String url) {
        return imageRepository.findByUrl(url);
    }

    @Override
    public Image savePublicFile(String base64File, String fileName) {
        byte[] bytes = Base64.decode(base64File);
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String filePath = getPublicImgeName(fileName);
        s3fFileStoreService.upload(getPath(), filePath, Optional.empty(), inputStream);
        return save(Image.builder().url(filePath).build());
    }

    private String getPublicImgeName(String originalName) {
        return String.format("%s/%s_%s", getPath(), UUID.randomUUID(), originalName);
    }

    @Override
    public String getFullImgUrl(String imageRelativeUrl) {
        return String.format("%s/%s/%s", tinyLazadaProperties.getAws().getS3().getHostName(), getPath(),
                imageRelativeUrl);
    }

    @Override
    public void delete(Long id) {
        Image img = imageRepository.findById(id).orElseThrow();
        img.setDeleted(true);
        s3fFileStoreService.delete(getPath(), img.getUrl());
    }

    private String getPath() {
        return tinyLazadaProperties.getAws().getS3().getBucketName();
    }

}
