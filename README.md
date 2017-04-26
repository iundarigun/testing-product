# testing-product

## Como criar um banco em docker
- Criar nova instancia local chamada mysql-products, escutando na porta 3306 (primeira vez)
```
$ sudo docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql-products -d mysql
```
- Conectar por terminal no mysql criado
```
$ docker exec -it mysql-products mysql -uroot -proot
```
- Criar banco por linha de comandos
```
create database products;
```
- Usar o banco
```
use products
```
- Mostrar as tabelas
show tables;
- Levantar a instancia de docker (após reiniciar)
```
$ docker start mysql-products
```

## Conetar por phpadmin
- Podemos conetar por phpadmin. Para isso, precisamos criar um novo container docker:
```
$ docker run -p 80:80 --link mysql-products:products --name admin-products -d tropicloud/phpadmin
```
Depois entra no http://localhost e logar com os seguintes dados:
server=products
username=root
password=root
database=products

- Inserts inicias nas tabelas:
```sql
INSERT INTO `category` (`id_category`, `nam_category`) 
VALUES
(1,	'telefonia'),
(2,	'game'),
(3,	'Livros'),
(4,	'Eletrodomésticos');

INSERT INTO `product` (`id_product`, `nam_product`, `val_product`, `id_category`) VALUES
(1,	'Moto G5 Plus',	999.00,	1),
(2,	'Ar Samsung Split',	1227.15,	4),
(3,	'Smart TV LED 49',	2999.90,	4),
(4,	'Console Playstation 4 Pro',	2226.90,	2),
(5,	'As crônicas de Nárnia',	15.90,	3),
(6,	'Box Assassin\'s creed vol 1',	49.90,	3),
(7,	'Box Sherlock Holmes 4 vol',	64.00,	3),
(8,	'O nome do vento',	24.50,	3),
(9,	'Pequenas grandes mentiras',	34.92,	3),
(10,	'Galaxy S8',	3999.00,	1),
(11,	'LG X power Dual',	619.99,	1),
(12,	'Mirage 41s',	289.90,	1),
(13,	'Galaxy A3',	799.99,	1),
(14,	'Asus Zenfone 3',	1599.00,	1),
(15,	'Console Playstation 4 Slim',	1194.90,	2),
(16,	'Horizon Zero Dawn - PS4',	169.90,	2),
(17,	'The Last Of Us Remasterizado - PS4',	99.99,	2),
(18,	'Xbox One 500gb',	1399.00,	2),
(19,	'Rise of the Tomb Raider - XBOX One',	89.90,	2),
(20,	'Lavadora de Roupas Electrolux 6kg',	912.51,	4),
(21,	'Geladeira/ Refrigerador Electrolux',	1899.99,	4),
(22,	'Forno Elétrico Philco 36l',	249.00,	4),
(23,	'Lava e Seca LG Mega Touch 8,5kg',	2199.99,	4);
```
