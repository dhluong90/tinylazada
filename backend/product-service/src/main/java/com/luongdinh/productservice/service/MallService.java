package com.luongdinh.productservice.service;

import com.luongdinh.productservice.dto.MallRequestDto;
import com.luongdinh.productservice.entity.Mall;
import com.luongdinh.productservice.repository.MallRepository;

public interface MallService extends CRUDService<Mall, Long, MallRepository> {

    /**
     * Create new mall from mall request.
     * 
     * @param mallRequest
     * @return
     */
    public Mall save(MallRequestDto mallRequest);

    /**
     * Update mall from mall request and mall ID.
     * 
     * @param mallId
     * @param mallRequest
     * @return
     */
    public Mall save(Long mallId, MallRequestDto mallRequest);
}
