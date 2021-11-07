package com.luong.tinylazada.common.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageResponse<T> {

    private List<T> content;
    private Integer pageNumber;
    private Integer totalPage;
    private Integer size;
}
