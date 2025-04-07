package com.izaiasvalentim.repository.persistence;

import com.izaiasvalentim.util.EntityManagerProducer;

import javax.persistence.EntityManager;

import java.util.List;

public abstract class Repositorio<T> implements RepositorioGeral<T> {

    private final Class<T> entityClass;

    protected final EntityManager manager;

    public Repositorio(Class<T> entityClass) {
        this.entityClass = entityClass;
        EntityManagerProducer emp = new EntityManagerProducer();
        this.manager = emp.createEntityManager();
    }

    @Override
    public T save(T entity) {
        return manager.merge(entity);
    }

    @Override
    public List<T> findAll() {
        return manager
                .createQuery("SELECT t FROM "+ entityClass.getSimpleName() +" t", entityClass).getResultList();
    }

    @Override
    public T findById(Object entityId) {
        return manager.find(entityClass, entityId);
    }

    @Override
    public T update(T entity) {
        return manager.merge(entity);
    }

}
