package com.luongdinh.tinylazada.common.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CRUDService<T, K, V extends PagingAndSortingRepository<T, K>> {
    public T save(T mall);

    public void delete(K id);

    public Optional<T> get(K id);

    public Iterable<T> getAll();

    public Page<T> getPage(int page, int size);
}
