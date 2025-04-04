package com.izaiasvalentim.model;

public enum TipoEmpresa {
	MEI("Microempreendedor individual"), EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"), SA("Sociedade Anônima");

	private String descricao;

	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
