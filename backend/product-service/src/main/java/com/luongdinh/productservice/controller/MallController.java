package com.luongdinh.productservice.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.luongdinh.productservice.dto.MallRequest;
import com.luongdinh.productservice.dto.MallResponse;
import com.luongdinh.productservice.entity.Mall;
import com.luongdinh.productservice.service.MallService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/malls")
@Slf4j
public class MallController {

    private MallService mallService;

    public MallController(MallService mallService) {
        this.mallService = mallService;
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
    public ResponseEntity<Page<MallResponse>> getListMall(@QueryParam("page") @Min(0) Integer page,
            @QueryParam("size") @Min(0) @Max(1000) Integer size) {
        Page<Mall> pageOfmall = mallService.getPage(page, size);
        ModelMapper mapper = new ModelMapper();
        return ResponseEntity.ok(pageOfmall.map(i -> mapper.map(pageOfmall, MallResponse.class)));
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
