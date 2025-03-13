CREATE TABLE tb_product
(
	product_name        VARCHAR(255)   NOT NULL,
	product_description VARCHAR(255)   NOT NULL,
	product_price       DECIMAL(10, 2) NOT NULL,
	product_amount      INTEGER        NOT NULL,
	CONSTRAINT pk_tb_product PRIMARY KEY (product_name)
);

CREATE TABLE tb_address
(
	address_street_name   VARCHAR(255) NOT NULL,
	address_street_number INTEGER      NOT NULL,
	address_city          VARCHAR(255),
	address_state         VARCHAR(255),
	address_zipcode       VARCHAR(255),
	address_country       VARCHAR(255),
	CONSTRAINT pk_tb_address PRIMARY KEY (address_street_name)
);

CREATE TABLE tb_supplier
(
	supplier_cnpj    VARCHAR(14)  NOT NULL,
	supplier_name    VARCHAR(255) NOT NULL,
	supplier_email   VARCHAR(255) NOT NULL,
	supplier_phone   VARCHAR(255) NOT NULL,
	supplier_address VARCHAR(255) NOT NULL,
	CONSTRAINT pk_tb_supplier PRIMARY KEY (supplier_cnpj)
);

ALTER TABLE tb_supplier
	ADD CONSTRAINT uc_tb_supplier_supplier_address UNIQUE (supplier_address);

ALTER TABLE tb_supplier
	ADD CONSTRAINT uc_tb_supplier_supplier_email UNIQUE (supplier_email);

ALTER TABLE tb_supplier
	ADD CONSTRAINT FK_TB_SUPPLIER_ON_SUPPLIER_ADDRESS FOREIGN KEY (supplier_address) REFERENCES tb_address (address_street_name);

-- Dados para tb_product
INSERT INTO tb_product (product_name, product_description, product_price, product_amount)
VALUES ('Notebook', 'Notebook de alta performance', 7500.00, 10),
			 ('Smartphone', 'Smartphone topo de linha', 4000.00, 25),
			 ('Fones de Ouvido', 'Fones de ouvido sem fio', 750.00, 40),
			 ('Teclado', 'Teclado mecânico com iluminação RGB', 375.00, 30),
			 ('Monitor', 'Monitor 4K Ultra HD', 1500.00, 15);

-- Dados para tb_address
INSERT INTO tb_address (address_street_name, address_street_number, address_city, address_state, address_zipcode,
												address_country)
VALUES ('Avenida Paulista', 123, 'São Paulo', 'SP', '01311-000', 'Brasil'),
			 ('Rua das Palmeiras', 456, 'Rio de Janeiro', 'RJ', '20011-000', 'Brasil'),
			 ('Avenida Paraná', 789, 'Curitiba', 'PR', '80010-000', 'Brasil'),
			 ('Rua Bahia', 101, 'Salvador', 'BA', '40010-000', 'Brasil'),
			 ('Avenida Amazonas', 202, 'Belo Horizonte', 'MG', '30110-000', 'Brasil');

-- Dados para tb_supplier
INSERT INTO tb_supplier (supplier_cnpj, supplier_name, supplier_email, supplier_phone, supplier_address)
VALUES ('1234567890123', 'Fornecedores Tech Ltda.', 'contato@fornecedorestech.com.br', '+55-11-5555-1234',
				'Avenida Paulista'),
			 ('2345678901223', 'Mundo Eletrônicos', 'info@mundoeletronicos.com.br', '+55-21-5555-5678', 'Rua das Palmeiras'),
			 ('3456789012323', 'Distribuidores de Gadgets', 'vendas@distribuidoresdegadgets.com.br', '+55-41-5555-8765',
				'Avenida Paraná'),
			 ('4567890123423', 'Hub de Hardware', 'suporte@hubdehardware.com.br', '+55-71-5555-4321', 'Rua Bahia'),
			 ('5678901234523', 'Depósito de Acessórios', 'ajuda@depositodeacessorios.com.br', '+55-31-5555-6789',
				'Avenida Amazonas');
