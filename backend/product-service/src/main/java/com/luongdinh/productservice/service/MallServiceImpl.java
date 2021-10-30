package com.luongdinh.productservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.luongdinh.productservice.configuration.TinyLazadaProperties;
import com.luongdinh.productservice.dto.MallRequestDto;
import com.luongdinh.productservice.entity.Image;
import com.luongdinh.productservice.entity.Mall;
import com.luongdinh.productservice.repository.MallRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MallServiceImpl extends AbstractCRUDService<Mall, Long, MallRepository> implements MallService {

    private MallRepository mallRepository;
    private ImageService imageService;
    private AmazonS3 amazonS3;
    private TinyLazadaProperties tinyLazadaProperties;

    @Autowired
    public MallServiceImpl(MallRepository mallRepository, ImageService imageService,
            TinyLazadaProperties tinyLazadaProperties) {
        this.mallRepository = mallRepository;
        this.imageService = imageService;
        this.tinyLazadaProperties = tinyLazadaProperties;
    }

    @Override
    protected MallRepository getEntityRepository() {
        return this.mallRepository;
    }

    @Override
    public Mall save(MallRequestDto mallRequest) {
        ModelMapper mapper = new ModelMapper();
        Mall mall = mapper.map(mallRequest, Mall.class);
        Image logo = imageService.savePublicFile(mallRequest.getBase64Logo(), mallRequest.getLogoName());
        mall.setLogo(logo);
        return save(mall);
    }

    @Override
    public Mall save(Long mallId, MallRequestDto mallRequest) {
        Mall mall = this.mallRepository.findById(mallId).orElseThrow();
        imageService.delete(mall.getId());
        return null;
    }

}
