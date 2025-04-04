package com.izaiasvalentim.repository;

import com.izaiasvalentim.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public Empresas() {
    }

    public Empresas(EntityManager manager) {
        this.manager = manager;
    }

    public Empresa buscarEmpresaPorId(Long id) {
        return manager.find(Empresa.class, id);
    }

    public List<Empresa> listarEmpresasPeloNomeFantasia(String nomeFantasia) {
        // TypedQuery<T> faz com que o retorno condiga com o tipo preciso <Empresa>
        TypedQuery<Empresa> query = manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);

        // Desta forma a consulta fica segura contra sql injection pois 'nomeFantasia' é tratado como um parâmetro e filtrado pelo hibernate.
        query.setParameter("nomeFantasia", nomeFantasia + "%");
        return query.getResultList();
    }

    public Empresa cadastrarEmpresa(Empresa empresa) {
        return manager.merge(empresa);
    }

    public void excluirEmpresaPorId(Long id) {
        Empresa empresa = this.buscarEmpresaPorId(id);

        manager.remove(empresa);
    }
}
