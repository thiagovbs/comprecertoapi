ALTER TABLE `usuario`
	ADD COLUMN `id_mercado` int(11);
	
ALTER TABLE `usuario`
	ADD FOREIGN KEY (`id_mercado`) REFERENCES `mercado` (`id_mercado`);