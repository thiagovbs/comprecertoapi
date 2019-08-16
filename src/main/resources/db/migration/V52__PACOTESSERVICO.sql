
UPDATE sheap.pacote_servico SET nome = 'Pacote Light', valor=60 where id_pacote_servico=19;
UPDATE sheap.pacote_servico SET nome = 'Pacote Premium', valor=170 , descricao='3' where id_pacote_servico=20;
UPDATE sheap.pacote_servico SET nome = 'Pacote Gold', valor=240, descricao='4'  where id_pacote_servico=21;
UPDATE sheap.pacote_servico SET nome = 'Pacote Deluxe', valor=345, descricao='6'  where id_pacote_servico=22;

UPDATE sheap.pacote_servico SET nome = 'Pacote Light', valor=80  where id_pacote_servico=10;
UPDATE sheap.pacote_servico SET nome = 'Pacote Premium', valor=160  where id_pacote_servico=11;
UPDATE sheap.pacote_servico SET nome = 'Pacote Gold', valor=240  where id_pacote_servico=12;
UPDATE sheap.pacote_servico SET nome = 'Pacote Deluxe', valor=320  where id_pacote_servico=13;



INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Deluxe', '7', 560, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Direct'), current_date, current_date);


UPDATE sheap.pacote_servico SET nome = 'Pacote Light', valor=80 where id_pacote_servico=23;
UPDATE sheap.pacote_servico SET nome = 'Pacote Premium', valor=150 where id_pacote_servico=24;
UPDATE sheap.pacote_servico SET nome = 'Pacote Gold', valor=290, descricao='4' where id_pacote_servico=25;






