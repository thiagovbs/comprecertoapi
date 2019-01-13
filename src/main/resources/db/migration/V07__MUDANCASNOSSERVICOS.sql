ALTER TABLE comprecertodb.servico DROP COLUMN tipo;

ALTER TABLE comprecertodb.pacote_servico
    ADD COLUMN valor DECIMAL(10,2) NOT NULL;

ALTER TABLE comprecertodb.pacote_servico
    ADD COLUMN acrescimo DECIMAL(10,2);

ALTER TABLE comprecertodb.pacote_servico
    ADD COLUMN desconto DECIMAL(10,2);

ALTER TABLE comprecertodb.pacote_servico
	CHANGE pacote_servicocol descricao VARCHAR(255);
    
ALTER TABLE comprecertodb.mercado_servico
	ADD COLUMN saldo DECIMAL(10,2);