package com.izaiasvalentim.repository;

import com.izaiasvalentim.model.RamoAtividade;
import com.izaiasvalentim.repository.persistence.Repositorio;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RamoRepositorio extends Repositorio<RamoAtividade> {

    public RamoRepositorio(){
        super(RamoAtividade.class);
    }

    public List<RamoAtividade> findAll(String descricao) {
        // A consulta também pode ser realizada por meio do Criteria.
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> cq = cb.createQuery(RamoAtividade.class);
        Root<RamoAtividade> root = cq.from(RamoAtividade.class);
        cq.select(root);
        cq.where(cb.like(root.get("descricao"), descricao + "%"));

        TypedQuery<RamoAtividade> query = manager.createQuery(cq);
        return query.getResultList();
    }
}
