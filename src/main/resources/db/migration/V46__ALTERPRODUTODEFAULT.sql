ALTER TABLE sheap.produto 
ALTER COLUMN venda_por_peso SET DEFAULT false;

	

UPDATE sheap.produto
SET venda_por_peso = false