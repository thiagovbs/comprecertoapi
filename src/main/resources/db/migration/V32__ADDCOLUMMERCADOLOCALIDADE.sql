	   
ALTER TABLE sheap.mercado_localidade
	ADD COLUMN horario_maximo timestamp without time zone;
	
ALTER TABLE sheap.mercado_localidade
	ADD COLUMN entrega character varying(1);
	
ALTER TABLE sheap.mercado_localidade
	ADD COLUMN telefone character varying(13);
	   
ALTER TABLE sheap.mercado_localidade
	ADD COLUMN frete boolean;

ALTER TABLE sheap.mercado_localidade
	ADD COLUMN valor_frete numeric(19,2);

ALTER TABLE sheap.mercado_localidade
	ADD COLUMN valor_minimo numeric(19,2);