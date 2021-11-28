package com.luongdinh.tinylazada.common.sdk.product.request;

import java.util.List;
import java.util.Optional;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSearchParamDto {
    private Optional<List<Long>> ids;
}
