sudo apt install mysql-server

sudo service mysql start

sudo mysql -uroot -p

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY ''

quit

mysql -uroot -p

create database produto

use produto

CREATE SCHEMA `produto` DEFAULT CHARACTER SET utf8

create table produto(
id int not null auto_increment primary key,
nome varchar(60),
valor decimal(11, 2),
descricao varchar(60),
desconto decimal(11, 2),
valorAposDesconto decimal(11, 2))

sudo service mysql stop