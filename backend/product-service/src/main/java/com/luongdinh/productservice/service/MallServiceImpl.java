package com.luongdinh.productservice.service;

import java.util.Optional;

import com.luongdinh.productservice.dto.MallRequest;
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

    @Autowired
    public MallServiceImpl(MallRepository mallRepository, ImageService imageService) {
        this.mallRepository = mallRepository;
        this.imageService = imageService;
    }

    @Override
    protected MallRepository getEntityRepository() {
        return this.mallRepository;
    }

    @Override
    public Mall save(MallRequest mallRequest) {
        ModelMapper mapper = new ModelMapper();
        Mall mall = mapper.map(mallRequest, Mall.class);
        Image logo = imageService.savePublicFile(mallRequest.getBase64Logo(), mallRequest.getLogoName());
        mall.setLogo(logo);
        return save(mall);
    }

    @Override
    public Mall save(Long mallId, MallRequest mallRequest) {
        return null;
    }

}
