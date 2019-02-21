CREATE TABLE sheap.bairro (
    id_bairro integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(100) NOT NULL,
    id_cidade integer NOT NULL
);

CREATE SEQUENCE sheap.bairro_id_bairro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.bairro_id_bairro_seq OWNED BY sheap.bairro.id_bairro;

CREATE TABLE sheap.categoria (
    id_categoria integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(100) NOT NULL
);

CREATE SEQUENCE sheap.categoria_id_categoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.categoria_id_categoria_seq OWNED BY sheap.categoria.id_categoria;

CREATE TABLE sheap.categoria_unidade_medida (
    id_unidade integer NOT NULL,
    id_categoria integer NOT NULL
);

CREATE TABLE sheap.cidade (
    id_cidade integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(100) NOT NULL,
    id_estado integer NOT NULL
);

CREATE SEQUENCE sheap.cidade_id_cidade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.cidade_id_cidade_seq OWNED BY sheap.cidade.id_cidade;

CREATE TABLE sheap.estado (
    id_estado integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(45) NOT NULL,
    sigla character varying(2) NOT NULL,
    id_pais integer NOT NULL
);

CREATE SEQUENCE sheap.estado_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.estado_id_estado_seq OWNED BY sheap.estado.id_estado;

CREATE TABLE sheap.faq (
    id_faq integer NOT NULL,
    descricao character varying(255) NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    plataforma character varying(255) NOT NULL,
    titulo character varying(100) NOT NULL
);

CREATE SEQUENCE sheap.faq_id_faq_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.faq_id_faq_seq OWNED BY sheap.faq.id_faq;

CREATE TABLE sheap.mercado (
    id_mercado integer NOT NULL,
    cnpj character varying(18) NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    email character varying(100) NOT NULL,
    f_ativo boolean,
    f_destaque boolean,
    f_super_destaque boolean,
    imagem_url character varying(255) NOT NULL,
    logo oid,
    nome_fantasia character varying(150) NOT NULL,
    razao_social character varying(150) NOT NULL,
    slogan text,
    telefone character varying(13) NOT NULL
);

CREATE SEQUENCE sheap.mercado_id_mercado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.mercado_id_mercado_seq OWNED BY sheap.mercado.id_mercado;

CREATE TABLE sheap.mercado_localidade (
    id_mercado_localidade integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    googlemaps_links character varying(255) NOT NULL,
    id_bairro integer NOT NULL,
    id_mercado integer
);

CREATE SEQUENCE sheap.mercado_localidade_id_mercado_localidade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.mercado_localidade_id_mercado_localidade_seq OWNED BY sheap.mercado_localidade.id_mercado_localidade;

CREATE TABLE sheap.mercado_produto (
    id_mercado_produto integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    dt_entrada timestamp without time zone NOT NULL,
    dt_validade timestamp without time zone NOT NULL,
    f_ativo boolean,
    f_destaque boolean,
    f_super_destaque boolean,
    observacao text,
    preco numeric(19,2) NOT NULL,
    id_mercado_localidade integer NOT NULL,
    id_produto integer NOT NULL
);

CREATE SEQUENCE sheap.mercado_produto_id_mercado_produto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.mercado_produto_id_mercado_produto_seq OWNED BY sheap.mercado_produto.id_mercado_produto;

CREATE TABLE sheap.mercado_push (
    id_mercado_push integer NOT NULL,
    data_hora_exibicao timestamp without time zone,
    data_validade timestamp without time zone,
    descricao character varying(255),
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    imagem oid,
    motivo_negativa text,
    promocao boolean,
    tipo_push smallint,
    id_categoria integer,
    id_mercado integer
);

CREATE SEQUENCE sheap.mercado_push_id_mercado_push_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.mercado_push_id_mercado_push_seq OWNED BY sheap.mercado_push.id_mercado_push;

CREATE TABLE sheap.mercado_servico (
    id_mercado_servico integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    dt_fim_servico timestamp without time zone,
    dt_inicio_servico timestamp without time zone,
    f_ativo boolean,
    saldo numeric(19,2) NOT NULL,
    id_mercado_localidade integer,
    id_pacote_servico integer NOT NULL
);

CREATE SEQUENCE sheap.mercado_servico_id_mercado_servico_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.mercado_servico_id_mercado_servico_seq OWNED BY sheap.mercado_servico.id_mercado_servico;

CREATE TABLE sheap.pacote_servico (
    id_pacote_servico integer NOT NULL,
    acrescimo numeric(19,2),
    desconto numeric(19,2),
    descricao character varying(255),
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(100),
    id_servico integer NOT NULL
);

CREATE SEQUENCE sheap.pacote_servico_id_pacote_servico_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.pacote_servico_id_pacote_servico_seq OWNED BY sheap.pacote_servico.id_pacote_servico;

CREATE TABLE sheap.pais (
    id_pais integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(150) NOT NULL,
    sigla character varying(3) NOT NULL
);

CREATE SEQUENCE sheap.pais_id_pais_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.pais_id_pais_seq OWNED BY sheap.pais.id_pais;

CREATE TABLE sheap.permissao (
    id_usuario integer NOT NULL,
    descricao character varying(30) NOT NULL
);

CREATE SEQUENCE sheap.permissao_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.permissao_id_usuario_seq OWNED BY sheap.permissao.id_usuario;

CREATE TABLE sheap.produto (
    id_produto integer NOT NULL,
    caracteristica text NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    marca character varying(100) NOT NULL,
    nome character varying(100) NOT NULL,
    quantidade integer NOT NULL,
    id_subcategoria integer NOT NULL,
    id_unidade_medida integer NOT NULL
);

CREATE SEQUENCE sheap.produto_id_produto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.produto_id_produto_seq OWNED BY sheap.produto.id_produto;

CREATE TABLE sheap.servico (
    id_servico integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(100)
);

CREATE SEQUENCE sheap.servico_id_servico_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.servico_id_servico_seq OWNED BY sheap.servico.id_servico;

CREATE TABLE sheap.subcategoria (
    id_subcategoria integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(100) NOT NULL,
    id_categoria integer NOT NULL
);

CREATE SEQUENCE sheap.subcategoria_id_subcategoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.subcategoria_id_subcategoria_seq OWNED BY sheap.subcategoria.id_subcategoria;

CREATE TABLE sheap.unidade_medida (
    id_unidade integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
    nome character varying(45) NOT NULL,
    sigla character varying(5) NOT NULL
);

CREATE SEQUENCE sheap.unidade_medida_id_unidade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.unidade_medida_id_unidade_seq OWNED BY sheap.unidade_medida.id_unidade;

CREATE TABLE sheap.usuario (
    id_usuario integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    dt_nascimento timestamp without time zone,
    email character varying(150) NOT NULL,
    f_ativo boolean,
    login character varying(18) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(100) NOT NULL,
    sexo character varying(1) NOT NULL,
    id_mercado integer
);

CREATE SEQUENCE sheap.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.usuario_id_usuario_seq OWNED BY sheap.usuario.id_usuario;

CREATE TABLE sheap.usuario_lista (
    id_usuario_lista integer NOT NULL,
    descricao character varying(50),
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    id_mercado_produto integer NOT NULL,
    id_usuario integer NOT NULL
);

CREATE SEQUENCE sheap.usuario_lista_id_usuario_lista_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.usuario_lista_id_usuario_lista_seq OWNED BY sheap.usuario_lista.id_usuario_lista;

CREATE TABLE sheap.usuario_mercado_push (
    id_usuario_mercado_push integer NOT NULL,
    dt_ativacao timestamp without time zone,
    id_mercado_push integer NOT NULL,
    id_usuario integer NOT NULL
);

CREATE SEQUENCE sheap.usuario_mercado_push_id_usuario_mercado_push_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.usuario_mercado_push_id_usuario_mercado_push_seq OWNED BY sheap.usuario_mercado_push.id_usuario_mercado_push;

CREATE TABLE sheap.usuario_permissao (
    id_usuario integer NOT NULL,
    id_permissao integer NOT NULL
);

ALTER TABLE ONLY sheap.bairro ALTER COLUMN id_bairro SET DEFAULT nextval('sheap.bairro_id_bairro_seq'::regclass);

ALTER TABLE ONLY sheap.categoria ALTER COLUMN id_categoria SET DEFAULT nextval('sheap.categoria_id_categoria_seq'::regclass);

ALTER TABLE ONLY sheap.cidade ALTER COLUMN id_cidade SET DEFAULT nextval('sheap.cidade_id_cidade_seq'::regclass);

ALTER TABLE ONLY sheap.estado ALTER COLUMN id_estado SET DEFAULT nextval('sheap.estado_id_estado_seq'::regclass);

ALTER TABLE ONLY sheap.faq ALTER COLUMN id_faq SET DEFAULT nextval('sheap.faq_id_faq_seq'::regclass);

ALTER TABLE ONLY sheap.mercado ALTER COLUMN id_mercado SET DEFAULT nextval('sheap.mercado_id_mercado_seq'::regclass);

ALTER TABLE ONLY sheap.mercado_localidade ALTER COLUMN id_mercado_localidade SET DEFAULT nextval('sheap.mercado_localidade_id_mercado_localidade_seq'::regclass);

ALTER TABLE ONLY sheap.mercado_produto ALTER COLUMN id_mercado_produto SET DEFAULT nextval('sheap.mercado_produto_id_mercado_produto_seq'::regclass);

ALTER TABLE ONLY sheap.mercado_push ALTER COLUMN id_mercado_push SET DEFAULT nextval('sheap.mercado_push_id_mercado_push_seq'::regclass);

ALTER TABLE ONLY sheap.mercado_servico ALTER COLUMN id_mercado_servico SET DEFAULT nextval('sheap.mercado_servico_id_mercado_servico_seq'::regclass);

ALTER TABLE ONLY sheap.pacote_servico ALTER COLUMN id_pacote_servico SET DEFAULT nextval('sheap.pacote_servico_id_pacote_servico_seq'::regclass);

ALTER TABLE ONLY sheap.pais ALTER COLUMN id_pais SET DEFAULT nextval('sheap.pais_id_pais_seq'::regclass);

ALTER TABLE ONLY sheap.permissao ALTER COLUMN id_usuario SET DEFAULT nextval('sheap.permissao_id_usuario_seq'::regclass);

ALTER TABLE ONLY sheap.produto ALTER COLUMN id_produto SET DEFAULT nextval('sheap.produto_id_produto_seq'::regclass);

ALTER TABLE ONLY sheap.servico ALTER COLUMN id_servico SET DEFAULT nextval('sheap.servico_id_servico_seq'::regclass);

ALTER TABLE ONLY sheap.subcategoria ALTER COLUMN id_subcategoria SET DEFAULT nextval('sheap.subcategoria_id_subcategoria_seq'::regclass);

ALTER TABLE ONLY sheap.unidade_medida ALTER COLUMN id_unidade SET DEFAULT nextval('sheap.unidade_medida_id_unidade_seq'::regclass);

ALTER TABLE ONLY sheap.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('sheap.usuario_id_usuario_seq'::regclass);

ALTER TABLE ONLY sheap.usuario_lista ALTER COLUMN id_usuario_lista SET DEFAULT nextval('sheap.usuario_lista_id_usuario_lista_seq'::regclass);

ALTER TABLE ONLY sheap.usuario_mercado_push ALTER COLUMN id_usuario_mercado_push SET DEFAULT nextval('sheap.usuario_mercado_push_id_usuario_mercado_push_seq'::regclass);

SELECT pg_catalog.setval('sheap.bairro_id_bairro_seq', 1, false);

SELECT pg_catalog.setval('sheap.categoria_id_categoria_seq', 1, false);

SELECT pg_catalog.setval('sheap.cidade_id_cidade_seq', 1, false);

SELECT pg_catalog.setval('sheap.estado_id_estado_seq', 1, false);

SELECT pg_catalog.setval('sheap.faq_id_faq_seq', 1, false);

SELECT pg_catalog.setval('sheap.mercado_id_mercado_seq', 1, false);

SELECT pg_catalog.setval('sheap.mercado_localidade_id_mercado_localidade_seq', 1, false);

SELECT pg_catalog.setval('sheap.mercado_produto_id_mercado_produto_seq', 1, false);

SELECT pg_catalog.setval('sheap.mercado_push_id_mercado_push_seq', 1, false);

SELECT pg_catalog.setval('sheap.mercado_servico_id_mercado_servico_seq', 1, false);

SELECT pg_catalog.setval('sheap.pacote_servico_id_pacote_servico_seq', 1, false);

SELECT pg_catalog.setval('sheap.pais_id_pais_seq', 1, false);

SELECT pg_catalog.setval('sheap.permissao_id_usuario_seq', 1, false);

SELECT pg_catalog.setval('sheap.produto_id_produto_seq', 1, false);

SELECT pg_catalog.setval('sheap.servico_id_servico_seq', 1, false);

SELECT pg_catalog.setval('sheap.subcategoria_id_subcategoria_seq', 1, false);

SELECT pg_catalog.setval('sheap.unidade_medida_id_unidade_seq', 1, false);

SELECT pg_catalog.setval('sheap.usuario_id_usuario_seq', 1, false);

SELECT pg_catalog.setval('sheap.usuario_lista_id_usuario_lista_seq', 1, false);

SELECT pg_catalog.setval('sheap.usuario_mercado_push_id_usuario_mercado_push_seq', 1, false);

ALTER TABLE ONLY sheap.bairro
    ADD PRIMARY KEY (id_bairro);

ALTER TABLE ONLY sheap.categoria
    ADD PRIMARY KEY (id_categoria);

ALTER TABLE ONLY sheap.categoria_unidade_medida
    ADD PRIMARY KEY (id_categoria, id_unidade);

ALTER TABLE ONLY sheap.cidade
    ADD PRIMARY KEY (id_cidade);

ALTER TABLE ONLY sheap.estado
    ADD PRIMARY KEY (id_estado);

ALTER TABLE ONLY sheap.faq
    ADD PRIMARY KEY (id_faq);

ALTER TABLE ONLY sheap.mercado_localidade
    ADD PRIMARY KEY (id_mercado_localidade);

ALTER TABLE ONLY sheap.mercado
    ADD PRIMARY KEY (id_mercado);

ALTER TABLE ONLY sheap.mercado_produto
    ADD PRIMARY KEY (id_mercado_produto);

ALTER TABLE ONLY sheap.mercado_push
    ADD PRIMARY KEY (id_mercado_push);

ALTER TABLE ONLY sheap.mercado_servico
    ADD PRIMARY KEY (id_mercado_servico);

ALTER TABLE ONLY sheap.pacote_servico
    ADD PRIMARY KEY (id_pacote_servico);

ALTER TABLE ONLY sheap.pais
    ADD PRIMARY KEY (id_pais);

ALTER TABLE ONLY sheap.permissao
    ADD PRIMARY KEY (id_usuario);

ALTER TABLE ONLY sheap.produto
    ADD PRIMARY KEY (id_produto);

ALTER TABLE ONLY sheap.servico
    ADD PRIMARY KEY (id_servico);

ALTER TABLE ONLY sheap.subcategoria
    ADD PRIMARY KEY (id_subcategoria);

ALTER TABLE ONLY sheap.usuario
    ADD UNIQUE (email);

ALTER TABLE ONLY sheap.usuario
    ADD UNIQUE (nome);

ALTER TABLE ONLY sheap.usuario
    ADD UNIQUE (login);

ALTER TABLE ONLY sheap.unidade_medida
    ADD PRIMARY KEY (id_unidade);

ALTER TABLE ONLY sheap.usuario_lista
    ADD PRIMARY KEY (id_usuario_lista);

ALTER TABLE ONLY sheap.usuario_mercado_push
    ADD PRIMARY KEY (id_usuario_mercado_push);

ALTER TABLE ONLY sheap.usuario_permissao
    ADD PRIMARY KEY (id_usuario, id_permissao);

ALTER TABLE ONLY sheap.usuario
    ADD PRIMARY KEY (id_usuario);

ALTER TABLE ONLY sheap.usuario_lista
    ADD FOREIGN KEY (id_mercado_produto) REFERENCES sheap.mercado_produto(id_mercado_produto);

ALTER TABLE ONLY sheap.subcategoria
    ADD FOREIGN KEY (id_categoria) REFERENCES sheap.categoria(id_categoria);

ALTER TABLE ONLY sheap.usuario_lista
    ADD FOREIGN KEY (id_usuario) REFERENCES sheap.usuario(id_usuario);

ALTER TABLE ONLY sheap.mercado_servico
    ADD FOREIGN KEY (id_pacote_servico) REFERENCES sheap.pacote_servico(id_pacote_servico);

ALTER TABLE ONLY sheap.mercado_push
    ADD FOREIGN KEY (id_mercado) REFERENCES sheap.mercado(id_mercado);

ALTER TABLE ONLY sheap.produto
    ADD FOREIGN KEY (id_unidade_medida) REFERENCES sheap.unidade_medida(id_unidade);

ALTER TABLE ONLY sheap.mercado_push
    ADD FOREIGN KEY (id_categoria) REFERENCES sheap.categoria(id_categoria);

ALTER TABLE ONLY sheap.usuario
    ADD FOREIGN KEY (id_mercado) REFERENCES sheap.mercado(id_mercado);

ALTER TABLE ONLY sheap.categoria_unidade_medida
    ADD FOREIGN KEY (id_categoria) REFERENCES sheap.categoria(id_categoria);

ALTER TABLE ONLY sheap.usuario_permissao
    ADD FOREIGN KEY (id_usuario) REFERENCES sheap.usuario(id_usuario);

ALTER TABLE ONLY sheap.bairro
    ADD FOREIGN KEY (id_cidade) REFERENCES sheap.cidade(id_cidade);

ALTER TABLE ONLY sheap.mercado_produto
    ADD FOREIGN KEY (id_produto) REFERENCES sheap.produto(id_produto);

ALTER TABLE ONLY sheap.usuario_mercado_push
    ADD FOREIGN KEY (id_mercado_push) REFERENCES sheap.mercado_push(id_mercado_push);

ALTER TABLE ONLY sheap.categoria_unidade_medida
    ADD FOREIGN KEY (id_unidade) REFERENCES sheap.unidade_medida(id_unidade);

ALTER TABLE ONLY sheap.estado
    ADD FOREIGN KEY (id_pais) REFERENCES sheap.pais(id_pais);

ALTER TABLE ONLY sheap.cidade
    ADD FOREIGN KEY (id_estado) REFERENCES sheap.estado(id_estado);

ALTER TABLE ONLY sheap.usuario_permissao
    ADD FOREIGN KEY (id_permissao) REFERENCES sheap.permissao(id_usuario);

ALTER TABLE ONLY sheap.mercado_servico
    ADD FOREIGN KEY (id_mercado_localidade) REFERENCES sheap.mercado_localidade(id_mercado_localidade);

ALTER TABLE ONLY sheap.mercado_localidade
    ADD FOREIGN KEY (id_bairro) REFERENCES sheap.bairro(id_bairro);

ALTER TABLE ONLY sheap.usuario_mercado_push
    ADD FOREIGN KEY (id_usuario) REFERENCES sheap.usuario(id_usuario);

ALTER TABLE ONLY sheap.produto
    ADD FOREIGN KEY (id_subcategoria) REFERENCES sheap.subcategoria(id_subcategoria);

ALTER TABLE ONLY sheap.pacote_servico
    ADD FOREIGN KEY (id_servico) REFERENCES sheap.servico(id_servico);

ALTER TABLE ONLY sheap.mercado_produto
    ADD FOREIGN KEY (id_mercado_localidade) REFERENCES sheap.mercado_localidade(id_mercado_localidade);

ALTER TABLE ONLY sheap.mercado_localidade
    ADD FOREIGN KEY (id_mercado) REFERENCES sheap.mercado(id_mercado);

