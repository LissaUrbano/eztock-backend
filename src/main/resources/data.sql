
/* PRODUTO ======================== */
INSERT INTO TB_PRODUTO (NOME, CODIGO_PRODUTO, CATEGORIA, PRECO, TAMANHO, EH_USADO) VALUES ('VESTIDO ANA MARIA', 'ACS548', 'VESTIDO', 159.99, 'UNICO', 0);
INSERT INTO TB_PRODUTO (NOME, CODIGO_PRODUTO, CATEGORIA, PRECO, TAMANHO, EH_USADO) VALUES ('CALÇA PANTALONA MARCIA', 'XX28', 'CALÇA', 189.99, 'M', 0);
INSERT INTO TB_PRODUTO (NOME, CODIGO_PRODUTO, CATEGORIA, PRECO, TAMANHO, EH_USADO) VALUES ('SHORTS JEANS AREZZO', 'UHASI', 'SHORTS', 89.99, 'GG', 1);

/* ESTOQUE ======================== */
INSERT INTO PRODUTO_ESTOQUE  (DATA_ESTOQUE,	QUANTIDADE,	PRODUTO_ID) VALUES ('2021-05-30', 10, 1);
INSERT INTO PRODUTO_ESTOQUE  (DATA_ESTOQUE,	QUANTIDADE,	PRODUTO_ID) VALUES ('2021-05-30', 20, 2);
INSERT INTO PRODUTO_ESTOQUE  (DATA_ESTOQUE,	QUANTIDADE,	PRODUTO_ID) VALUES ('2021-05-30', 1, 3);

/* VENDA ======================== */
INSERT INTO PRODUTO_VENDA (DATA_VENDA, QUANTIDADE, PRODUTO_ID) VALUES ('2021-05-30', 5, 1);


