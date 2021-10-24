package com.luongdinh.productservice.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MallRequest {
    @NotBlank(message = "Mall name can't be blank")
    private String name;
    @NotBlank(message = "Logo file can't be blank")
    private String base64Logo;
    @NotBlank(message = "Logo name can't be blank")
    private String logoName;
}
