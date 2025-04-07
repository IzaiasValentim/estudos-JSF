package com.izaiasvalentim.repository.persistence;

import java.util.List;

public interface RepositorioGeral<T>{
    T save(T entity);

    T update(T entity);

    T findById(Object entityId);

    List<T> findAll();
}
