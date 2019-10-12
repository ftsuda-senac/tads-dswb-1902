CREATE TABLE PRODUTO (
  ID           BIGINT        NOT NULL AUTO_INCREMENT,
  NOME         VARCHAR(100)  NOT NULL,
  DESCRICAO    VARCHAR(1000) NULL,
  PRECO_COMPRA DECIMAL(9,2)  NOT NULL,
  PRECO_VENDA  DECIMAL(9,2)  NOT NULL,
  QUANTIDADE   INT           NOT NULL DEFAULT 0,
  DISPONIVEL   BOOL          NOT NULL DEFAULT TRUE,       
  DT_CADASTRO  TIMESTAMP     NOT NULL,
  CONSTRAINT PK_PRODUTO PRIMARY KEY (ID)
);

CREATE TABLE CATEGORIA (
  ID   INT          NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL,
  CONSTRAINT PK_CATEGORIA PRIMARY KEY (ID),
  CONSTRAINT UC_NOME UNIQUE (NOME)
);

CREATE TABLE IMAGEM_PRODUTO (
  ID           BIGINT        NOT NULL AUTO_INCREMENT,
  NOME_ARQUIVO VARCHAR(500)  NOT NULL,
  LEGENDA      VARCHAR(1000) NULL,
  ID_PRODUTO   BIGINT        NOT NULL,
  CONSTRAINT PK_IMAGEM_PRODUTO PRIMARY KEY (ID),
  CONSTRAINT FK_IMAGEM_PRODUTO FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO(ID)
);

CREATE TABLE PRODUTO_CATEGORIA (
  ID_PRODUTO   BIGINT NOT NULL,
  ID_CATEGORIA INT    NOT NULL,
  CONSTRAINT FK_PRODUTO FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO(ID),
  CONSTRAINT FK_CATEGORIA FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID)
);

INSERT INTO CATEGORIA (NOME) VALUES
('Categoria 1'),
('Categoria 2'),
('Categoria 3'),
('Categoria 4'),
('Categoria 5');

INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO) VALUES
('Eletrônico', 'Descrição do produto Eletrônico', 100.0, 200.0, 100, CURRENT_TIMESTAMP()),
('Roupa', 'Descrição do produto Roupa', 40.0, 70.0, 200, CURRENT_TIMESTAMP()),
('Viagem', 'Descrição do produto Viagem', 800.0, 1100.0, 20, CURRENT_TIMESTAMP()),
('Esporte', 'Descrição do produto Esporte', 200.0, 300.0, 150, CURRENT_TIMESTAMP()),
('Comida', 'Descrição do produto Comida', 15.0, 30.0, 500, CURRENT_TIMESTAMP()),
('Diversão', 'Descrição do produto Diversão', 120.0, 350.0, 150, CURRENT_TIMESTAMP());

INSERT INTO PRODUTO_CATEGORIA (ID_PRODUTO, ID_CATEGORIA) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(4, 1),
(4, 3),
(5, 2),
(5, 4),
(5, 5),
(6, 3),
(6, 5);

INSERT INTO IMAGEM_PRODUTO (NOME_ARQUIVO, LEGENDA, ID_PRODUTO) VALUES
('http://lorempixel.com/300/300/technics/1/', 'technics 1', 1),
('http://lorempixel.com/300/300/technics/2/', 'technics 2', 1),
('http://lorempixel.com/300/300/technics/7/', 'technics 7', 1),
('http://lorempixel.com/300/300/fashion/1/', 'fashion 1', 2),
('http://lorempixel.com/300/300/fashion/3/', 'fashion 3', 2),
('http://lorempixel.com/300/300/fashion/6/', 'fashion 6', 2),
('http://lorempixel.com/300/300/animals/1/', 'animals 1', 3),
('http://lorempixel.com/300/300/animals/2/', 'animals 2', 3),
('http://lorempixel.com/300/300/animals/4/', 'animals 4', 3),
('http://lorempixel.com/300/300/sports/2/', 'sports 2', 4),
('http://lorempixel.com/300/300/sports/3/', 'sports 3', 4),
('http://lorempixel.com/300/300/food/1/', 'food 1', 5),
('http://lorempixel.com/300/300/food/3/', 'food 3', 5),
('http://lorempixel.com/300/300/food/9/', 'food 9', 5),
('http://lorempixel.com/300/300/nightlife/2/', 'nightlife 2', 6),
('http://lorempixel.com/300/300/nightlife/10/', 'nightlife 10', 6);
