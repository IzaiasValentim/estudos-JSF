package com.izaiasvalentim.repository.persistence;

import com.izaiasvalentim.model.Empresa;

import com.izaiasvalentim.util.EntityManagerProducer;

import javax.persistence.EntityManager;

import java.util.List;

public abstract class Repositorio<T> implements RepositorioGeral {

    private Class<T> entityClass;

    protected final EntityManager manager;

    public Repositorio(Class<T> entityClass) {
        this.entityClass = entityClass;
        EntityManagerProducer emp = new EntityManagerProducer();
        this.manager = emp.createEntityManager();
    }

    @Override
    public Object save(Object entity) {
        return manager.merge(entity);
    }

    @Override
    public List<T> findAll() {
        return manager
                .createQuery("SELECT t FROM "+ entityClass.getSimpleName() +" t", entityClass).getResultList();
    }

    @Override
    public Object findById(Object entityId) {
        return manager.find(entityClass, entityId);
    }

    @Override
    public Object update(Object entity) {
        return manager.merge(entity);
    }

}
