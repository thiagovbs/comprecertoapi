package br.com.comprecerto.api.entities.enums;

public enum Pagamento {

	D("Débito"), C("Crédito"), E("Dinheiro");

	private String descricao;

	private Pagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
