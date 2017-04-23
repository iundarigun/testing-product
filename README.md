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
docker start mysql-products
```
- Inserts inicias na tabela area:
insert into area (nam_area, dat_creation, num_version) values('Java', curdate(), 0);
insert into area (nam_area, dat_creation, num_version) values('DotNet', curdate(), 0);
insert into area (nam_area, dat_creation, num_version) values('Android', curdate(), 0);
insert into area (nam_area, dat_creation, num_version) values('IPhone', curdate(), 0);
insert into area (nam_area, dat_creation, num_version) values('DBA', curdate(), 0);
insert into area (nam_area, dat_creation, num_version) values('Infra', curdate(), 0);
