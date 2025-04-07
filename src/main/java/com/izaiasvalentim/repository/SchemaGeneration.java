package com.izaiasvalentim.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.izaiasvalentim.model.Empresa;
import com.izaiasvalentim.model.RamoAtividade;

public class SchemaGeneration {
    public static void main(String[] args) {
        EmpresaRepositorio empresaRepositorio = new EmpresaRepositorio();
        RamoRepositorio ramoRepositorio = new RamoRepositorio();
    }
}
