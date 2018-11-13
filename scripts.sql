insert into usuario (dt_criacao, dt_alteracao, dt_nascimento, email, f_ativo, login, nome, senha, sexo) values (current_date, current_date, current_date, 'elias.brazjunior@gmail.com', 1, 'ebraz', 'Elias Braz', 'braz..', 'M');
insert into permissao (descricao) values ('MERCADO_ADMIN');
insert into usuario_permissao (id_usuario, id_permissao) values (1,1);
