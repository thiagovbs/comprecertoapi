INSERT INTO sheap.servico (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Anuncio de produtos');
INSERT INTO sheap.servico (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Posicionamento supermercado');
INSERT INTO sheap.servico (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Push Plus');
INSERT INTO sheap.servico (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Push Direct');
INSERT INTO sheap.servico (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Boost Destaque');
INSERT INTO sheap.servico (dt_alteracao, dt_criacao, f_ativo, nome) VALUES (current_date, current_date, true, 'Boost Super-destaque');

SELECT pg_catalog.setval('sheap.servico_id_servico_seq', 7, false);

INSERT INTO sheap.pacote_servico (dt_alteracao, dt_criacao, f_ativo, nome, descricao, id_servico) VALUES (current_date, current_date, true, 'Light', 'Pacote Light 480 produtos/mês', 1);
INSERT INTO sheap.pacote_servico (dt_alteracao, dt_criacao, f_ativo, nome, descricao, id_servico) VALUES (current_date, current_date, true, 'Destaque', 'Pacote Light 480 produtos/mês', 2);
INSERT INTO sheap.pacote_servico (dt_alteracao, dt_criacao, f_ativo, nome, descricao, id_servico) VALUES (current_date, current_date, true, '1/4 mês', '1 anúncio multi por mês', 3);
INSERT INTO sheap.pacote_servico (dt_alteracao, dt_criacao, f_ativo, nome, descricao, id_servico) VALUES (current_date, current_date, true, '2/4 mês', '1 anúncio alvo a cada 15 dias', 4);
INSERT INTO sheap.pacote_servico (dt_alteracao, dt_criacao, f_ativo, nome, descricao, id_servico) VALUES (current_date, current_date, true, '64 mês', '1 anúncio multi por mês', 5);
INSERT INTO sheap.pacote_servico (dt_alteracao, dt_criacao, f_ativo, nome, descricao, id_servico) VALUES (current_date, current_date, true, '48 mês', '2 produtos dia anunciado', 6);

SELECT pg_catalog.setval('sheap.pacote_servico_id_pacote_servico_seq', 7, false);