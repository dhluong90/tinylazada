package com.luongdinh.productservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.luong.tinylazada.common.dto.PageResponse;
import com.luongdinh.productservice.dto.ProductDetailRequestDto;
import com.luongdinh.productservice.dto.ProductListResponseDto;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.entity.ProductReview;
import com.luongdinh.productservice.repository.ProductRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractCRUDService<Product, Long, ProductRepository>
        implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PageResponse<ProductListResponseDto> getProductsByPage(PageRequest pageRequest) {
        Page<Product> productPage = productRepository.findAll(pageRequest);
        List<ProductListResponseDto> productListReponses = productPage.get().map(i -> {
            ProductListResponseDto pro = modelMapper.map(i, ProductListResponseDto.class);
            List<ProductReview> productReview = i.getProductReview();
            pro.setAverageStar(productReview.stream().mapToDouble(ProductReview::getNumberOfStar).average().orElse(0D));
            pro.setTotalReview(productReview.size());
            return pro;
        }).collect(Collectors.toList());
        return PageResponse.<ProductListResponseDto>builder().content(productListReponses)
                .pageNumber(productPage.getNumber()).totalPage(productPage.getSize()).build();
    }

    @Override
    protected ProductRepository getEntityRepository() {
        return productRepository;
    }

    @Override
    public Product create(ProductDetailRequestDto productDetailRequestDto) {
        return productRepository.save(productDetailRequestDto.toProduct());
    }

    @Override
    public Product update(Long id, ProductDetailRequestDto productDetailRequestDto) {
        Product product = productDetailRequestDto.toProduct();
        product.setId(id);
        return productRepository.save(product);
    }
}
