package br.com.comprecerto.api.entities.enums;

public enum Substituicao {

	E("Pode excluir o produto"), L("Gostaria que me ligasse"), S("Pode substituir por um produto de valor similar");

	private String descricao;

	private Substituicao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
