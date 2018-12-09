INSERT INTO comprecertodb.categoria (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, 1, 'Categoria 1');
INSERT INTO comprecertodb.categoria (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, 1, 'Categoria 2');
INSERT INTO comprecertodb.categoria (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, 1, 'Categoria 3');

INSERT INTO comprecertodb.categoria_unidade_medida (id_unidade, id_categoria) VALUES (1,1);
INSERT INTO comprecertodb.categoria_unidade_medida (id_unidade, id_categoria) VALUES (1,2);
INSERT INTO comprecertodb.categoria_unidade_medida (id_unidade, id_categoria) VALUES (2,1);
INSERT INTO comprecertodb.categoria_unidade_medida (id_unidade, id_categoria) VALUES (3,2);

INSERT INTO comprecertodb.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, 1, 'Subcategoria 1', 1);
INSERT INTO comprecertodb.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, 1, 'Subcategoria 2', 2);
INSERT INTO comprecertodb.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, 1, 'Subcategoria 1', 2);
INSERT INTO comprecertodb.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, 1, 'Subcategoria 3', 3);
INSERT INTO comprecertodb.subcategoria (dt_alteracao, dt_criacao, f_ativo, nome, id_categoria) VALUES (current_date, current_date, 1, 'Subcategoria 3', 1);
