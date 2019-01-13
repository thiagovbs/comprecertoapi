DROP TABLE `mercado_localidade_googlemaps_links`;

ALTER TABLE `mercado_localidade`
	ADD COLUMN `googlemaps_links` TEXT NOT NULL;