ALTER TABLE sheap.pedido 
ALTER COLUMN valor_frete drop not null;

ALTER TABLE sheap.pedido 
ALTER COLUMN troco drop not null;

ALTER TABLE sheap.pedido 
ALTER COLUMN endereco drop not null;

ALTER TABLE sheap.pedido 
ALTER COLUMN data_horario_retirada drop not null;