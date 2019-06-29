package br.com.comprecerto.api.entities.enums;

public enum Entrega {

	E("Entrega"), R("Retirada");

	private String descricao;

	private Entrega(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
