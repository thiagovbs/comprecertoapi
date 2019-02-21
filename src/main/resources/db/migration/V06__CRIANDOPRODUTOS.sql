INSERT INTO sheap.produto (caracteristica, dt_alteracao, dt_criacao,  marca, nome, quantidade, id_subcategoria, id_unidade_medida) VALUES ('Característica 1', current_date, current_date,  'Marca 1', 'Produto 1', 1, 1, 1);
INSERT INTO sheap.produto (caracteristica, dt_alteracao, dt_criacao,  marca, nome, quantidade, id_subcategoria, id_unidade_medida) VALUES ('Característica 2', current_date, current_date,  'Marca 2', 'Produto 2', 2, 2, 1);
INSERT INTO sheap.produto (caracteristica, dt_alteracao, dt_criacao,  marca, nome, quantidade, id_subcategoria, id_unidade_medida) VALUES ('Característica 3', current_date, current_date,  'Marca 3', 'Produto 3', 3, 2, 3);

SELECT pg_catalog.setval('sheap.produto_id_produto_seq', 4, false);