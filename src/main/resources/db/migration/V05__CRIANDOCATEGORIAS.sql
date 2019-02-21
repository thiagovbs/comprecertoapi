INSERT INTO sheap.categoria (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Categoria 1');
INSERT INTO sheap.categoria (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Categoria 2');
INSERT INTO sheap.categoria (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Categoria 3');

SELECT pg_catalog.setval('sheap.categoria_id_categoria_seq', 4, false);

INSERT INTO sheap.categoria_unidade_medida (id_unidade, id_categoria) VALUES (1,1);
INSERT INTO sheap.categoria_unidade_medida (id_unidade, id_categoria) VALUES (1,2);
INSERT INTO sheap.categoria_unidade_medida (id_unidade, id_categoria) VALUES (2,1);
INSERT INTO sheap.categoria_unidade_medida (id_unidade, id_categoria) VALUES (3,2);

INSERT INTO sheap.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, true, 'Subcategoria 1', 1);
INSERT INTO sheap.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, true, 'Subcategoria 2', 2);
INSERT INTO sheap.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, true, 'Subcategoria 1', 2);
INSERT INTO sheap.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, true, 'Subcategoria 3', 3);
INSERT INTO sheap.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, true, 'Subcategoria 3', 1);

SELECT pg_catalog.setval('sheap.subcategoria_id_subcategoria_seq', 6, false);