-- ="INSERT INTO comprecertodb.unidade_medida (f_ativo, nome, sigla) VALUES (1, '"&B4&"', '"&C4&"', current_date, current_date);"
INSERT INTO comprecertodb.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (1, 'Kilograma', 'Kg', current_date, current_date);
INSERT INTO comprecertodb.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (1, 'Grama', 'g', current_date, current_date);
INSERT INTO comprecertodb.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (1, 'Litro', 'L', current_date, current_date);
INSERT INTO comprecertodb.unidade_medida (f_ativo, nome, sigla, dt_criacao, dt_alteracao) VALUES (1, 'Miligrama', 'ml', current_date, current_date);

-- ="INSERT INTO comprecertodb.categoria (f_ativo, nome) VALUES (1, '"&B4&"', current_date, current_date);"
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Bebidas', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Carnes e pescados', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Despensa', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Doces', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Freezer', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Geladeira', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Higiene', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Hortifrúti', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Padarias', current_date, current_date);
INSERT INTO comprecertodb.categoria (f_ativo, nome, dt_criacao, dt_alteracao) VALUES (1, 'Limpeza', current_date, current_date);

INSERT INTO comprecertodb.categoria_unidade_medida
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('Kg')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('g')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('L')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'));
INSERT INTO comprecertodb.categoria_unidade_medida 
    (SELECT 
        (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla in ('ml')),
        (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'));

-- ="INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, '"&D4&"', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = '"&B4&"'), current_date, current_date);"
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Cerveja', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Refrigerante', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Suco', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Água', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Chá', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Energético', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Vinho', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Destilado', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Espumante', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Bebidas'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Bovino', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Ave', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Suíno', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Peixes', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Frutos do Mar', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Linguiças', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Carnes e pescados'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Grão e Farináceo', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Massas e Molhos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Temperos e Condimentos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Biscoitos e Aperitivos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Sopa', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Café', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Cereais e Complementos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Bebês', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Pets', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Descartáveis', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Despensa'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Chocolate', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Balas', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Gelatina', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Cremes e Derivados', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Confeitos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Doces'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Lanches', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Pratos Prontos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Legumes Congelados', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Sorvete', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Sobremesas', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Polpas de Frutas', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Freezer'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Queijos e Derivados', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Laticínio', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Frios e Embutidos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Massas Frescas', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Geladeira'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Bocal', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Corporal', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Capilar', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Facial', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Barba e Depilação', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Bebê', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Higiene'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Legumes', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Verduras', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Frutas', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Temperos Frescos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Processados', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Hortifrúti'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Pães', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Bolo', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Torradas', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Mistura de Bolos', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Fermento', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Padarias'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Multiuso', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Cozinha', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Banheiro', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Lavanderia', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Área de Serviço', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'), current_date, current_date);
INSERT INTO comprecertodb.subcategoria (f_ativo, nome, id_categoria, dt_criacao, dt_alteracao) VALUES (1, 'Outros', (SELECT id_categoria FROM comprecertodb.categoria WHERE nome = 'Limpeza'), current_date, current_date);

-- ="INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('"&F4&"', '"&E4&"', '"&D4&"', "&G4&", (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = '"&C4&"'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = '"&H4&"'), current_date, current_date);"
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Coca Cola', 'Refrigerante', 600, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Refrigerante'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Zero', 'Coca Cola', 'Refrigerante', 1.5, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Refrigerante'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'L'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Beats Senses', 'Skol', 'Cerveja', 269, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Cerveja'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Friboi', 'Picanha', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Bovino'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Maturatta', 'Friboi', 'Fraudinha', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Bovino'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Porto', 'x', 'Bacalhau', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Peixes'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Pomarola', 'Molho de tomate', 340, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Massas e Molhos'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Gourmet', '3 corações', 'Café', 250, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Café'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Maisena', 'Piraquê', 'Biscoito', 200, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Biscoitos e Aperitivos'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Dimante Negro e Laka', 'Lacta', 'Chocolate', 135, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Chocolate'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Ursinhos', 'Fini', 'Goma', 100, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Balas'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Italac', 'Doce de Leite', 400, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Cremes e Derivados'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Taeq', 'Brócolis', 300, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Legumes Congelados'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Lombo', 'Sadia', 'Pizza', 460, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Lanches'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Parmegiana de Frango', 'Sadia', 'Pratos Prontos', 350, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Pratos Prontos'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Grego', 'Vigor', 'Iogurte', 100, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Laticínio'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Defumado', 'Sadia', 'Presunto', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Frios e Embutidos'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Prato', 'President', 'Queijo', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Queijos e Derivados'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Total 12', 'Colgate', 'Creme dental', 90, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Bocal'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Johmsons', 'Sabonete', 80, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Bebê'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
-- INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Mach 3', 'Gillette', 'Barbeador', x, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Barba e Depilação'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'x'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'x', 'Chuchu', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Legumes'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'x', 'Alface', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Verduras'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'x', 'Maça', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Frutas'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'Kg'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Australiano', 'x', 'Pão', 100, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Pães'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Em Pó Quimico', 'Royal', 'Fermento', 100, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Fermento'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Comum', 'Dona Benta', 'Brownie', 450, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Mistura de Bolos'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'g'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Rende Mais', 'Ype', 'Detergente', 500, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Cozinha'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('5 em 1', 'Pato', 'Desinfetante', 500, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Banheiro'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'ml'), current_date, current_date);
INSERT INTO comprecertodb.produto (caracteristica, marca, nome, quantidade, id_subcategoria, id_unidade_medida, dt_criacao, dt_alteracao) VALUES ('Intese', 'Comfort', 'Amaciante', 1, (SELECT id_subcategoria FROM comprecertodb.subcategoria WHERE nome = 'Lavanderia'), (SELECT id_unidade FROM comprecertodb.unidade_medida WHERE sigla = 'L'), current_date, current_date);

-- ="INSERT INTO comprecertodb.servico (nome, f_ativo) VALUES ('"&B4&"', 1);"
INSERT INTO comprecertodb.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Anúncio de produtos', 1, current_date, current_date);
INSERT INTO comprecertodb.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Boost Destaque', 1, current_date, current_date);
INSERT INTO comprecertodb.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Boost Super Destaque', 1, current_date, current_date);
INSERT INTO comprecertodb.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Posicionamento', 1, current_date, current_date);
INSERT INTO comprecertodb.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Push Plus', 1, current_date, current_date);
INSERT INTO comprecertodb.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Push Direct', 1, current_date, current_date);
INSERT INTO comprecertodb.servico (nome, f_ativo, dt_criacao, dt_alteracao) VALUES ('Alcance de Retirada', 1, current_date, current_date);

-- ="INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico) VALUES (1, '"&C4&"', '"&D4&"', "&E4&", (SELECT id_servico FROM comprecertodb.servico WHERE nome = '"&B4&"'), current_date, current_date);"
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote Light', '480', 1440, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Anúncio de produtos'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote Premium', '720', 2160, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Anúncio de produtos'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote Deluxe', '960', 2880, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Anúncio de produtos'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 1', '16', 120, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 2', '32', 220, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 3', '48', 300, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 4', '64', 450, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Boost Destaque'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 1', '16', 280, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Boost Super Destaque'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 2', '32', 504 , (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Boost Super Destaque'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 3', '48', 790, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Boost Super Destaque'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote Destaque', 'x', 672, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Posicionamento'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote Super Destaque', 'x', 1142, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Posicionamento'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 1', '1', 200, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 2', '2', 360, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 3', '3', 500, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 4', '4', 730, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Push Plus'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 1', '1', 560, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Push Direct'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 2', '2', 1.010, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Push Direct'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Pacote 3', '3', 1.570, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Push Direct'), current_date, current_date);
INSERT INTO comprecertodb.pacote_servico (f_ativo, nome, descricao, valor, id_servico, dt_criacao, dt_alteracao) VALUES (1, 'Único', 'x', 500, (SELECT id_servico FROM comprecertodb.servico WHERE nome = 'Alcance de Retirada'), current_date, current_date);
