-- ="INSERT INTO sheap.unidade_medida (f_ativo, nome, sigla) VALUES (1, '"&B4&"', '"&C4&"', current_date, current_date);"
INSERT INTO sheap.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (true, 'Kilograma', 'Kg', current_date, current_date);
INSERT INTO sheap.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (true, 'Grama', 'g', current_date, current_date);
INSERT INTO sheap.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (true, 'Litro', 'L', current_date, current_date);
INSERT INTO sheap.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (true, 'Miligrama', 'ml', current_date, current_date);

SELECT pg_catalog.setval('sheap.unidade_medida_id_unidade_seq', 100, false);

-- ="INSERT INTO sheap.categoria (f_ativo, nome) VALUES (1, '"&B4&"', current_date, current_date);"
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Bebidas', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Carnes e pescados', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Despensa', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Doces', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Freezer', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Geladeira', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Higiene', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Hortifrúti', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Padarias', current_date, current_date);
INSERT INTO sheap.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (true, 'Limpeza', current_date, current_date);

SELECT pg_catalog.setval('sheap.categoria_id_categoria_seq', 100, false);

INSERT INTO sheap.categoria_unidade_medida
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'));
INSERT INTO sheap.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'));

-- ="INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, '"&D4&"', (SELECT id_categoria FROM sheap.categoria WHERE nome = '"&B4&"'), current_date, current_date);"
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Cerveja', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Refrigerante', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Suco', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Água', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Chá', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Energético', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Vinho', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Destilado', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Espumante', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Bovino', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Ave', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Suíno', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Peixes', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Frutos do Mar', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Linguiças', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Grão e Farináceo', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Massas e Molhos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Temperos e Condimentos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Biscoitos e Aperitivos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Sopa', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Café', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Cereais e Complementos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Bebês', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Pets', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Descartáveis', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Chocolate', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Balas', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Gelatina', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Cremes e Derivados', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Confeitos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Lanches', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Pratos Prontos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Legumes Congelados', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Sorvete', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Sobremesas', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Polpas de Frutas', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Queijos e Derivados', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Laticínio', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Frios e Embutidos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Massas Frescas', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Bocal', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Corporal', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Capilar', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Facial', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Barba e Depilação', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Bebê', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Legumes', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Verduras', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Frutas', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Temperos Frescos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Processados', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Pães', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Bolo', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Torradas', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Mistura de Bolos', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Fermento', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Multiuso', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Cozinha', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Banheiro', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Lavanderia', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Área de Serviço', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO sheap.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (true, 'Outros', (SELECT id_categoria FROM sheap.categoria WHERE nome = 'Limpeza'), current_date, current_date);

SELECT pg_catalog.setval('sheap.subcategoria_id_subcategoria_seq', 100, false);

-- ="INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('"&F4&"', '"&E4&"', '"&D4&"', "&G4&", (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = '"&C4&"'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = '"&H4&"'), current_date, current_date);"
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Coca Cola', 'Refrigerante', 600, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Refrigerante'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Zero', 'Coca Cola', 'Refrigerante', 1.5, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Refrigerante'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'L'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Beats Senses', 'Skol', 'Cerveja', 269, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Cerveja'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Friboi', 'Picanha', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Bovino'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Maturatta', 'Friboi', 'Fraudinha', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Bovino'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Porto', 'x', 'Bacalhau', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Peixes'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Pomarola', 'Molho de tomate', 340, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Massas e Molhos'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Gourmet', '3 corações', 'Café', 250, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Café'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Maisena', 'Piraquê', 'Biscoito', 200, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Biscoitos e Aperitivos'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Dimante Negro e Laka', 'Lacta', 'Chocolate', 135, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Chocolate'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Ursinhos', 'Fini', 'Goma', 100, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Balas'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Italac', 'Doce de Leite', 400, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Cremes e Derivados'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Taeq', 'Brócolis', 300, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Legumes Congelados'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Lombo', 'Sadia', 'Pizza', 460, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Lanches'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Parmegiana de Frango', 'Sadia', 'Pratos Prontos', 350, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Pratos Prontos'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Grego', 'Vigor', 'Iogurte', 100, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Laticínio'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Defumado', 'Sadia', 'Presunto', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Frios e Embutidos'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Prato', 'President', 'Queijo', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Queijos e Derivados'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Total 12', 'Colgate', 'Creme dental', 90, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Bocal'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Johmsons', 'Sabonete', 80, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Bebê'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
-- INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Mach 3', 'Gillette', 'Barbeador', x, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Barba e Depilação'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'x'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'x', 'Chuchu', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Legumes'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'x', 'Alface', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Verduras'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'x', 'Maça', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Frutas'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Australiano', 'x', 'Pão', 100, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Pães'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Em Pó Quimico', 'Royal', 'Fermento', 100, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Fermento'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Dona Benta', 'Brownie', 450, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Mistura de Bolos'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Rende Mais', 'Ype', 'Detergente', 500, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Cozinha'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('5 em 1', 'Pato', 'Desinfetante', 500, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Banheiro'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO sheap.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Intese', 'Comfort', 'Amaciante', 1, (SELECT id_subcategoria FROM sheap.subcategoria WHERE nome = 'Lavanderia'), (SELECT id_unidade FROM sheap.unidade_medida WHERE sigla = 'L'), current_date, current_date);

SELECT pg_catalog.setval('sheap.produto_id_produto_seq', 100, false);

-- ="INSERT INTO sheap.servico (nome, f_ativo) VALUES ('"&B4&"', 1);"
INSERT INTO sheap.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Anúncio de produtos', true, current_date, current_date);
INSERT INTO sheap.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Boost Destaque', true, current_date, current_date);
INSERT INTO sheap.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Posicionamento', true, current_date, current_date);
INSERT INTO sheap.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Push Plus', true, current_date, current_date);
INSERT INTO sheap.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Push Direct', true, current_date, current_date);

SELECT pg_catalog.setval('sheap.servico_id_servico_seq', 100, false);

-- ="INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico) VALUES (1, '"&C4&"', '"&D4&"', "&E4&", (SELECT id_servico FROM sheap.servico WHERE nome = '"&B4&"'), current_date, current_date);"
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Light', '60', 1440, (SELECT id_servico FROM sheap.servico WHERE nome = 'Anúncio de produtos'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Premium', '90', 2160, (SELECT id_servico FROM sheap.servico WHERE nome = 'Anúncio de produtos'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Deluxe', '120', 2880, (SELECT id_servico FROM sheap.servico WHERE nome = 'Anúncio de produtos'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Light', '2', 80, (SELECT id_servico FROM sheap.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Premium', '4', 160, (SELECT id_servico FROM sheap.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Gold', '6', 240, (SELECT id_servico FROM sheap.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Deluxe', '8', 320, (SELECT id_servico FROM sheap.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Comum', 'x', 0, (SELECT id_servico FROM sheap.servico WHERE nome = 'Posicionamento'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Destaque', 'x', 672, (SELECT id_servico FROM sheap.servico WHERE nome = 'Posicionamento'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Super Destaque', 'x', 1142, (SELECT id_servico FROM sheap.servico WHERE nome = 'Posicionamento'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Light', '1', 60, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Premium', '3', 170, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Gold', '4', 240, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Deluxe', '6', 345, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Light', '1', 80, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Direct'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Premium', '2', 150, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Direct'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Gold', '4', 290, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Direct'), current_date, current_date);
INSERT INTO sheap.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (true, 'Pacote Deluxe', '5', 560, (SELECT id_servico FROM sheap.servico WHERE nome = 'Push Direct'), current_date, current_date);

SELECT pg_catalog.setval('sheap.pacote_servico_id_pacote_servico_seq', 100, false);