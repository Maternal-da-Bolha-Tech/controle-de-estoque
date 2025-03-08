CREATE TABLE tb_product
(
    product_name        VARCHAR(255)   NOT NULL,
    product_description VARCHAR(255)   NOT NULL,
    product_price       DECIMAL(10, 2) NOT NULL,
    product_amount      INTEGER        NOT NULL,
    CONSTRAINT pk_tb_product PRIMARY KEY (product_name)
);

/*
Os dados inseridos neste arquivo .sql são apenas para fins de teste.
Eles têm como objetivo simular um conjunto inicial de informações que podem ser utilizadas
em um banco de dados para validações, demonstrações ou desenvolvimento de funcionalidades.
Esses dados não devem ser utilizados em um ambiente de produção.
*/
INSERT INTO tb_product (product_name, product_description, product_price, product_amount)
VALUES ('Laptop', 'High performance laptop', 1500.00, 50),
       ('Smartphone', 'Latest model smartphone', 800.00, 200),
       ('Headphones', 'Noise-cancelling headphones', 120.50, 100),
       ('Keyboard', 'Mechanical keyboard', 70.99, 150),
       ('Mouse', 'Wireless ergonomic mouse', 45.49, 300),
       ('Monitor', '4K Ultra HD monitor', 310.00, 80),
       ('Tablet', 'Portable touchscreen tablet', 600.00, 120),
       ('Smartwatch', 'Waterproof smartwatch', 199.99, 250),
       ('Speaker', 'Bluetooth portable speaker', 85.00, 400),
       ('External Hard Drive', '1TB external hard drive', 120.00, 150);
