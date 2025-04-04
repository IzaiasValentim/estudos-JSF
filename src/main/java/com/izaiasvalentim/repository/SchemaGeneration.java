package com.izaiasvalentim.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.izaiasvalentim.model.Empresa;
import com.izaiasvalentim.model.RamoAtividade;

public class SchemaGeneration {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IzaiasValentimPU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		RamoAtividades ramoRepositorio = new RamoAtividades(em);
		Empresas empresasRepositorio = new Empresas(em);

		List<RamoAtividade> ramos = ramoRepositorio.buscarRamoAtividade("");
		List<Empresa> empresas = empresasRepositorio.listarEmpresasPeloNomeFantasia("");

		System.out.println(ramos);
		System.out.println(empresas);
	}
}
