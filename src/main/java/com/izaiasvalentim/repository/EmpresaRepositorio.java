package com.izaiasvalentim.repository;

import com.izaiasvalentim.model.Empresa;
import com.izaiasvalentim.repository.persistence.Repositorio;

import javax.persistence.TypedQuery;
import java.util.List;

public class EmpresaRepositorio extends Repositorio<Empresa> {

    public EmpresaRepositorio(){
        super(Empresa.class);
    }

    public List<Empresa> findAll(String nomeFantasia){
        TypedQuery<Empresa> query = manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);

        query.setParameter("nomeFantasia", nomeFantasia + "%");
        return query.getResultList();
    }
}
