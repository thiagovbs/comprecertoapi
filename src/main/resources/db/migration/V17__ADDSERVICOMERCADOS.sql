INSERT INTO sheap.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Sheap Direct', true, current_date, current_date);

SELECT pg_catalog.setval('sheap.servico_id_servico_seq', 15, false);

INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Entrega em Casa', 'x', 0, (SELECT id_servico FROM sheap.servico WHERE nome = 'Sheap Direct'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Retirada na Loja', 'x', 0, (SELECT id_servico FROM sheap.servico WHERE nome = 'Sheap Direct'), current_date, current_date);

SELECT pg_catalog.setval('sheap.pacote_servico_id_pacote_servico_seq', 27, false);