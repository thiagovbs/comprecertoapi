INSERT INTO comprecertodb.usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha, sexo) VALUES (current_date, current_date, current_date, 'elias.brazjunior@gmail.com', 1, 'ebraz', 'Elias Braz', 'braz..', 'M');
INSERT INTO comprecertodb.permissao (descricao) VALUES ('MERCADO_ADMIN');
INSERT INTO comprecertodb.usuario_permissao (id_usuario, id_permissao) VALUES (1,1);
