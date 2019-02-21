INSERT INTO sheap.usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha, sexo) VALUES (current_date, current_date, current_date, 'elias.brazjunior@gmail.com', true, 'ebraz', 'Elias Braz', 'braz..', 'M');
INSERT INTO sheap.permissao (descricao) VALUES ('MERCADO_ADMIN');
INSERT INTO sheap.usuario_permissao (id_usuario, id_permissao) VALUES (1,1);

SELECT pg_catalog.setval('sheap.usuario_id_usuario_seq', 2, false);
SELECT pg_catalog.setval('sheap.permissao_id_usuario_seq', 2, false);