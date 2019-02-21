INSERT INTO sheap.unidade_medida (dt_alteracao, dt_criacao, f_ativo, nome, sigla) VALUES (current_date, current_date, true, 'Unidade Medida 1', 'UM1');
INSERT INTO sheap.unidade_medida (dt_alteracao, dt_criacao, f_ativo, nome, sigla) VALUES (current_date, current_date, true, 'Unidade Medida 2', 'UM2');
INSERT INTO sheap.unidade_medida (dt_alteracao, dt_criacao, f_ativo, nome, sigla) VALUES (current_date, current_date, true, 'Unidade Medida 3', 'UM3');

SELECT pg_catalog.setval('sheap.unidade_medida_id_unidade_seq', 4, false);