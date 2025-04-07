package com.izaiasvalentim.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
    EntityManagerFactory factory;

    public EntityManagerProducer() {
        this.factory = Persistence.createEntityManagerFactory("IzaiasValentimPU");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return this.factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager) {
        manager.close();
    }
}
