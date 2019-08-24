INSERT INTO sheap.permissao (descricao) VALUES ('MERCADO_ADMIN');
INSERT INTO sheap.permissao (descricao) VALUES ('MERCADO_OPERADOR');
INSERT INTO sheap.permissao (descricao) VALUES ('USUARIO');




INSERT INTO sheap.usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha) VALUES (current_date, current_date, current_date, 'ceo@sheap.com.br', true, 'ceo@sheap.com.br', 'CEO SHEAP', '{bcrypt}$2a$10$srhlxYSCu9Qc4s4ZjWV0VeQ6lhi0WAI6O38FwXfII2sYwJj/tOhbK');

INSERT INTO sheap.usuario_permissao (id_usuario, id_permissao) 
    VALUES ((SELECT id_usuario FROM sheap.usuario WHERE login = 'ceo@sheap.com.br'), (SELECT id_permissao FROM sheap.permissao WHERE descricao = 'MERCADO_ADMIN'));

	
INSERT INTO sheap.usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha) VALUES (current_date, current_date, current_date, 'cto@sheap.com.br', true, 'cto@sheap.com.br', 'CTO SHEAP', '{bcrypt}$2a$10$p5MpKkeuTAQQx6wkpQ18suaIkWv3B7dxJmO6O0Fd0ltjbKUtazZ.i');

INSERT INTO sheap.usuario_permissao (id_usuario, id_permissao) 
    VALUES ((SELECT id_usuario FROM sheap.usuario WHERE login = 'cto@sheap.com.br'), (SELECT id_permissao FROM sheap.permissao WHERE descricao = 'MERCADO_ADMIN'));
	
	
INSERT INTO sheap.usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha) VALUES (current_date, current_date, current_date, 'cmo@sheap.com.br', true, 'cmo@sheap.com.br', 'CMO SHEAP', '{bcrypt}$2a$10$FAoYnPLmqfXaFcpmyQch4OZqvhBvoPZ23y4RaMLspn2MEEn69zcsS');

INSERT INTO sheap.usuario_permissao (id_usuario, id_permissao) 
    VALUES ((SELECT id_usuario FROM sheap.usuario WHERE login = 'cmo@sheap.com.br'), (SELECT id_permissao FROM sheap.permissao WHERE descricao = 'MERCADO_ADMIN'));


