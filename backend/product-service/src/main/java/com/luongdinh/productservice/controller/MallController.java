package com.luongdinh.productservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

import com.luong.common.tinylazada.dto.PageResponse;
import com.luongdinh.productservice.dto.MallRequest;
import com.luongdinh.productservice.dto.MallResponse;
import com.luongdinh.productservice.entity.Mall;
import com.luongdinh.productservice.service.ImageService;
import com.luongdinh.productservice.service.MallService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/malls")
@Slf4j
public class MallController {

    private MallService mallService;
    private ImageService imageService;

    public MallController(MallService mallService, ImageService imageService) {
        this.mallService = mallService;
        this.imageService = imageService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<MallResponse> createMall(@RequestBody @Valid MallRequest mallRequest) {
        log.info("start createMall(@RequestBody MallRequest mallRequest)");
        ModelMapper mapper = new ModelMapper();
        ResponseEntity<MallResponse> returnMe = ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.map(mallService.save(mallRequest), MallResponse.class));
        log.info("end createMall(@RequestBody MallRequest mallRequest)");
        return returnMe;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    @Validated
    public ResponseEntity<PageResponse<MallResponse>> getListMall(@RequestParam("page") @NotNull @Min(0) Integer page,
            @RequestParam("size") @NotNull @Min(0) @Max(1000) Integer size) {
        Page<Mall> pageOfmall = mallService.getPage(page, size);
        List<MallResponse> mallResponses = pageOfmall.get().map(MallResponse::fromMall).peek(i -> {
            i.setLogoUrl(imageService.getFullImageUrl(i.getLogoUrl()));
        }).collect(Collectors.toList());
        PageResponse<MallResponse> returnMe = PageResponse.<MallResponse>builder().pageNumber(pageOfmall.getNumber())
                .size(pageOfmall.getSize()).totalPage(pageOfmall.getNumberOfElements()).content(mallResponses).build();
        return ResponseEntity.ok(returnMe);
    }

    @DeleteMapping("/{mallId}")
    public ResponseEntity<Void> deleteMall(@PathVariable @NotNull Long mallId) {
        mallService.delete(mallId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{mallId}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<MallResponse> updateMall(@RequestBody @Valid MallRequest mallRequest) {
        return ResponseEntity.ok().build();
    }
}
