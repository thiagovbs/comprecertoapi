package br.com.comprecerto.api.entities.enums;

public enum Status {

	S("Em separação"), T("Em transporte"), E("Entregue") , N("Pedido negado") , 
	L("Em análise"), A("Aprovado"), R("Aguardando retirada"), F("Finalizado");

	private String descricao;

	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
