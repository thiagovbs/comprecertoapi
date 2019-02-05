INSERT INTO comprecertodb.usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha, sexo) VALUES (current_date, current_date, current_date, 'philipe.lopes07@gmail.com', 1, 'famorim', 'Philip Amorim', 'famorim', 'M');
INSERT INTO comprecertodb.permissao (descricao) VALUES ('MERCADO_OPERADOR');
INSERT INTO comprecertodb.usuario_permissao (id_usuario, id_permissao) 
    VALUES ((SELECT id_usuario FROM comprecertodb.usuario WHERE login = 'famorim'), (SELECT id_usuario FROM comprecertodb.permissao WHERE descricao = 'MERCADO_OPERADOR'));
