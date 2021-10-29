package com.luongdinh.productservice.service;

import java.util.Optional;

import com.luongdinh.productservice.entity.Image;
import com.luongdinh.productservice.repository.ImageRepository;

public interface ImageService extends CRUDService<Image, Long, ImageRepository> {

    public Optional<Image> getImageByURl(String url);

    /**
     * allow to persist file to system and create corresponding imge record
     * 
     * @param base64File
     * @param fileName
     * @return
     */
    public Image savePublicFile(String base64File, String fileName);

    /**
     * convert relative url in image to full url.
     * 
     * @param image
     * @return
     */
    public String getFullImgUrl(String image);

}
