CREATE TABLE `faq` (
  `id_faq` int(11) NOT NULL AUTO_INCREMENT,
  `dt_alteracao` datetime,
  `dt_criacao` datetime,
  `f_ativo` tinyint(1),
  `titulo` varchar(100) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_faq`)
);