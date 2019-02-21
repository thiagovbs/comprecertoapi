ALTER TABLE sheap.usuario
	ADD COLUMN data_hora_exibicao timestamp without time zone,
	ADD COLUMN promocao bigint,
	ADD COLUMN data_validade timestamp without time zone,
	ADD COLUMN id_categoria bigint;
	
ALTER TABLE sheap.usuario
	ADD FOREIGN KEY (id_categoria) REFERENCES sheap.categoria (id_categoria);