ALTER TABLE sheap.produto
	ADD COLUMN ean integer;

ALTER TABLE ONLY sheap.produto
    ADD UNIQUE (ean);