ALTER SEQUENCE permissao_id_usuario_seq RENAME TO permissao_id_permissao_seq;


ALTER TABLE ONLY sheap.permissao ALTER COLUMN id_permissao SET DEFAULT nextval('sheap.permissao_id_permissao_seq'::regclass);


