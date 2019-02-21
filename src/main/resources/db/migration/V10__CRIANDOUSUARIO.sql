INSERT INTO sheap.usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha, sexo) VALUES (current_date, current_date, current_date, 'philipe.lopes07@gmail.com', true, 'famorim', 'Philip Amorim', 'famorim', 'M');
INSERT INTO sheap.permissao (descricao) VALUES ('MERCADO_OPERADOR');
INSERT INTO sheap.usuario_permissao (id_usuario, id_permissao) 
    VALUES ((SELECT id_usuario FROM sheap.usuario WHERE login = 'famorim'), (SELECT id_usuario FROM sheap.permissao WHERE descricao = 'MERCADO_OPERADOR'));

SELECT pg_catalog.setval('sheap.usuario_id_usuario_seq', 3, false);
SELECT pg_catalog.setval('sheap.permissao_id_usuario_seq', 3, false);