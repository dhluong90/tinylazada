package com.luongdinh.productservice.service;

import com.luongdinh.productservice.dto.MallRequestDto;
import com.luongdinh.productservice.entity.Image;
import com.luongdinh.productservice.entity.Mall;
import com.luongdinh.productservice.repository.MallRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MallServiceImpl extends AbstractCRUDService<Mall, Long, MallRepository> implements MallService {

    private MallRepository mallRepository;
    private ImageService imageService;

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
