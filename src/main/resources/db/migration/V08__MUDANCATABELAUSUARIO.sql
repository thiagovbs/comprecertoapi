ALTER TABLE sheap.usuario
	ADD FOREIGN KEY (id_mercado) REFERENCES sheap.mercado (id_mercado);