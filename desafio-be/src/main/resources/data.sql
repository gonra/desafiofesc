insert into typeproduct values (1, 'Eletrônico')
insert into typeproduct values (2, 'Eletrodoméstico')
insert into typeproduct values (3, 'Móvel')

insert into typeoperation values (1, 'ENTRADA')
insert into typeoperation values (2, 'SAIDA')
insert into typeoperation values (3, 'CONFERENCIA DE STOCK')

insert into product (id, code, description, last_update, provider_price, stock, type_product_id) values (1, 'cod1001', 'LCD SONY 26POL', '2021-01-01 12:00:00', 1120.0, 0, 1) 
insert into product (id, code, description, last_update, provider_price, stock, type_product_id) values (2, 'cod1002', 'SMARTPHONE XIAMI X9', '2021-01-01 12:00:00', 2020.0, 10, 1) 
insert into product (id, code, description, last_update, provider_price, stock, type_product_id) values (3, 'cod2003', 'CADEIRA LUXO', '2021-01-01 12:00:00', 620.0, 5, 3) 
insert into product (id, code, description, last_update, provider_price, stock, type_product_id) values (4, 'cod3004', 'ASPIRADORA ', '2021-01-01 12:00:00', 310.0, 4, 2) 
insert into product (id, code, description, last_update, provider_price, stock, type_product_id) values (5, 'cod3005', 'GELADEIRA', '2021-01-01 12:00:00', 1120.0, 3, 2) 
insert into product (id, code, description, last_update, provider_price, stock, type_product_id) values (6, 'cod2006', 'MESA DE COMPUTADOR BRANCO', '2021-01-01 12:00:00', 260.0, 0, 3) 