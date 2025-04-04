package com.izaiasvalentim.repository;

import com.izaiasvalentim.model.RamoAtividade;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class RamoAtividades implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public RamoAtividades() {
    }

    public RamoAtividades(EntityManager em) {
        this.manager = em;
    }

    public List<RamoAtividade> buscarRamoAtividade(String descricao) {
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
