CREATE TABLE sheap.pedido (
    id_pedido integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
	status character varying(1) NOT NULL,
	entrega character varying(1) NOT NULL,
	valor_frete numeric(19,2) NOT NULL,
	pagamento character varying(1) NOT NULL,
	troco numeric(19,2) NOT NULL,
	telefone character varying(13) NOT NULL,
	celular character varying(14) NOT NULL,
	endereco character varying(100) NOT NULL,
	dataHorarioRetirada timestamp without time zone,
    id_usuario integer NOT NULL,
	id_mercado_localidade integer NOT NULL
    
);

CREATE SEQUENCE sheap.pedido_id_pedido_seq
    
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.pedido_id_pedido_seq OWNED BY sheap.pedido.id_pedido;


CREATE TABLE sheap.pedido_produto (
    id_pedido_produto integer NOT NULL,
    dt_alteracao timestamp without time zone,
    dt_criacao timestamp without time zone,
    f_ativo boolean,
	preco numeric(19,2) NOT NULL,
    quantidade integer NOT NULL,
    id_produto integer NOT NULL,
	id_pedido integer NOT NULL
);

CREATE SEQUENCE sheap.pedido_produto_id_pedido_produto_seq
    
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE sheap.pedido_produto_id_pedido_produto_seq OWNED BY sheap.pedido_produto.id_pedido_produto;



ALTER TABLE ONLY sheap.pedido_produto ALTER COLUMN id_pedido_produto SET DEFAULT nextval('sheap.pedido_produto_id_pedido_produto_seq'::regclass);

ALTER TABLE ONLY sheap.pedido ALTER COLUMN id_pedido SET DEFAULT nextval('sheap.pedido_id_pedido_seq'::regclass);


SELECT pg_catalog.setval('sheap.pedido_produto_id_pedido_produto_seq', 1, false);

SELECT pg_catalog.setval('sheap.pedido_id_pedido_seq', 1, false);


ALTER TABLE ONLY sheap.pedido_produto
    ADD PRIMARY KEY (id_pedido_produto);

ALTER TABLE ONLY sheap.pedido
    ADD PRIMARY KEY (id_pedido);


ALTER TABLE ONLY sheap.pedido
    ADD FOREIGN KEY (id_usuario) REFERENCES sheap.usuario(id_usuario);

ALTER TABLE ONLY sheap.pedido
    ADD FOREIGN KEY (id_mercado_localidade) REFERENCES sheap.mercado_localidade(id_mercado_localidade);
	

ALTER TABLE ONLY sheap.pedido_produto
    ADD FOREIGN KEY (id_produto) REFERENCES sheap.produto(id_produto);

ALTER TABLE ONLY sheap.pedido_produto
    ADD FOREIGN KEY (id_pedido) REFERENCES sheap.pedido(id_pedido);

