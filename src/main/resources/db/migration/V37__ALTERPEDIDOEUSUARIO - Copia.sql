ALTER TABLE sheap.usuario
	ADD COLUMN cpf character varying(14);
	
ALTER TABLE sheap.usuario
	ADD COLUMN whatsapp boolean;	
	
ALTER TABLE sheap.pedido 
RENAME COLUMN datahorarioretirada TO data_horario_retirada;	