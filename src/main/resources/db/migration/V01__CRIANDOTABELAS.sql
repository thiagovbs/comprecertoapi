CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(150) NOT NULL,
  `sigla` varchar(3) NOT NULL,
  PRIMARY KEY (`id_pais`)
);

CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(2) NOT NULL,
  `id_pais` int(11) NOT NULL,
  PRIMARY KEY (`id_estado`),
  UNIQUE KEY (`nome`),
  UNIQUE KEY (`sigla`),
  FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`)
);

CREATE TABLE `cidade` (
  `id_cidade` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `id_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_cidade`),
  UNIQUE KEY (`nome`),
  FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`)
);

CREATE TABLE `bairro` (
  `id_bairro` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime NOT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  PRIMARY KEY (`id_bairro`),
  UNIQUE KEY (`nome`),
  FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id_cidade`)
);

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY (`nome`)
);

CREATE TABLE `unidade_medida` (
  `id_unidade` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(5) NOT NULL,
  PRIMARY KEY (`id_unidade`)
);

CREATE TABLE `categoria_unidade_medida` (
  `id_unidade` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  KEY (`id_categoria`),
  KEY (`id_unidade`),
  FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  FOREIGN KEY (`id_unidade`) REFERENCES `unidade_medida` (`id_unidade`)
);

CREATE TABLE `mercado` (
  `id_mercado` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `f_destaque` tinyint(1) DEFAULT NULL,
  `f_super_destaque` tinyint(1) DEFAULT NULL,
  `logo` longblob,
  `nome_fantasia` varchar(150) NOT NULL,
  `razao_social` varchar(150) NOT NULL,
  `slogan` longtext,
  `telefone` varchar(255) NOT NULL,
  PRIMARY KEY (`id_mercado`),
  UNIQUE KEY (`cnpj`),
  UNIQUE KEY (`email`)
);

CREATE TABLE `mercado_localidade` (
  `id_mercado_localidade` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `id_bairro` int(11) NOT NULL,
  `id_mercado` int(11) NOT NULL,
  PRIMARY KEY (`id_mercado_localidade`),
  FOREIGN KEY (`id_bairro`) REFERENCES `bairro` (`id_bairro`),
  FOREIGN KEY (`id_mercado`) REFERENCES `mercado` (`id_mercado`)
);

CREATE TABLE `mercado_localidade_googlemaps_links` (
  `mercado_localidade_id_mercado_localidade` int(11) NOT NULL,
  `googlemaps_link` varchar(255) NOT NULL,
  FOREIGN KEY (`mercado_localidade_id_mercado_localidade`) REFERENCES `mercado_localidade` (`id_mercado_localidade`)
);

CREATE TABLE `subcategoria` (
  `id_subcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_subcategoria`),
  FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
);

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `caracteristica` longtext NOT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `imagem` varchar(255) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `id_subcategoria` int(11) NOT NULL,
  `id_unidade_medida` int(11) NOT NULL,
  PRIMARY KEY (`id_produto`),
  FOREIGN KEY (`id_unidade_medida`) REFERENCES `unidade_medida` (`id_unidade`),
  FOREIGN KEY (`id_subcategoria`) REFERENCES `subcategoria` (`id_subcategoria`)
);

CREATE TABLE `mercado_produto` (
  `id_mercado_produto` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `dt_entrada` datetime NOT NULL,
  `dt_validade` datetime NOT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `f_destaque` tinyint(1) DEFAULT NULL,
  `f_super_destaque` tinyint(1) DEFAULT NULL,
  `observacao` longtext,
  `preco` decimal(19,2) NOT NULL,
  `id_mercado_localidade` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  PRIMARY KEY (`id_mercado_produto`),
  FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`),
  FOREIGN KEY (`id_mercado_localidade`) REFERENCES `mercado_localidade` (`id_mercado_localidade`)
);

CREATE TABLE `mercado_push` (
  `id_mercado_push` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `imagem` longblob,
  `motivo_negativa` longtext,
  `tipo_push` smallint(6) DEFAULT NULL,
  `id_mercado` int(11) NOT NULL,
  PRIMARY KEY (`id_mercado_push`),
  FOREIGN KEY (`id_mercado`) REFERENCES `mercado` (`id_mercado`)
);

CREATE TABLE `servico` (
  `id_servico` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `tipo` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_servico`)
);

CREATE TABLE `pacote_servico` (
  `id_pacote_servico` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `pacote_servicocol` varchar(45) DEFAULT NULL,
  `id_servico` int(11) NOT NULL,
  PRIMARY KEY (`id_pacote_servico`),
  FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`)
);

CREATE TABLE `mercado_servico` (
  `id_mercado_servico` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `dt_fim_servico` datetime DEFAULT NULL,
  `dt_inicio_servico` datetime DEFAULT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `id_mercado_localidade` int(11) NOT NULL,
  `id_pacote_servico` int(11) NOT NULL,
  PRIMARY KEY (`id_mercado_servico`),
  FOREIGN KEY (`id_pacote_servico`) REFERENCES `pacote_servico` (`id_pacote_servico`),
  FOREIGN KEY (`id_mercado_localidade`) REFERENCES `mercado_localidade` (`id_mercado_localidade`)
);

CREATE TABLE `permissao` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `dt_nascimento` datetime DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `f_ativo` tinyint(1) DEFAULT NULL,
  `login` varchar(18) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY (`email`),
  UNIQUE KEY (`login`),
  UNIQUE KEY (`nome`)
);

CREATE TABLE `usuario_lista` (
  `id_usuario_lista` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  `dt_alteracao` datetime DEFAULT NULL,
  `dt_criacao` datetime DEFAULT NULL,
  `id_mercado_produto` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario_lista`),
  FOREIGN KEY (`id_mercado_produto`) REFERENCES `mercado_produto` (`id_mercado_produto`),
  FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
);

CREATE TABLE `usuario_mercado_push` (
  `id_usuario_mercado_push` int(11) NOT NULL AUTO_INCREMENT,
  `dt_ativacao` datetime DEFAULT NULL,
  `id_mercado_push` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario_mercado_push`),
  FOREIGN KEY (`id_mercado_push`) REFERENCES `mercado_push` (`id_mercado_push`),
  FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
);

CREATE TABLE `usuario_permissao` (
  `id_usuario` int(11) NOT NULL,
  `id_permissao` int(11) NOT NULL,
  FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  FOREIGN KEY (`id_permissao`) REFERENCES `permissao` (`id_usuario`)
);