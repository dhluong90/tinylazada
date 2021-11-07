package com.luongdinh.productservice.service;

import java.util.Optional;

import com.luong.tinylazada.common.entity.GenericEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class AbstractCRUDService<T extends GenericEntity, K, V extends PagingAndSortingRepository<T, K>>
        implements CRUDService<T, K, V> {

    public T save(T t) {
        return getEntityRepository().save(t);
    }

    public void delete(K id) {
        getEntityRepository().deleteById(id);
    }

    public Optional<T> get(K id) {
        return getEntityRepository().findById(id);
    }

    public Iterable<T> getAll() {
        return getEntityRepository().findAll();
    }

    public Page<T> getPage(int page, int size) {
        return getEntityRepository().findAll(PageRequest.of(page, size));
    }

    protected abstract PagingAndSortingRepository<T, K> getEntityRepository();
}
