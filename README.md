# mvc-jsp
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gabrielssantana/mvc-jsp/blob/main/LICENSE) 

# Sobre o projeto

Este projeto é para um processo seletivo para estágio em desenvolvimento Java.
Consiste em um CRUD, utilizando Java JSP para servir as páginas com os dados retornados do MySql.
Utilizei o pattern MVC para organizar a estrutura do projeto.

# Tecnologias utilizadas
- Java 11
- Apache Tomcat 10
- MySql
- Java Server Pages (JSP)
- HTML
- JavaScript

# Como executar o projeto
**Pré-requisitos:**
- Eclipse Java EE IDE
- Java 11
- MySql
- Apache Tomcat

```bash
# clonar repositório
git clone https://github.com/gabrielssantana/mvc-jsp

#instalação MySql Ubuntu 20.04

sudo apt update

sudo apt install mysql-server

sudo service mysql start

sudo mysql -uroot -p

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '';

quit

mysql -uroot -p

create database produto;

use produto;

CREATE SCHEMA `produto` DEFAULT CHARACTER SET utf8;

create table produto(
id int not null auto_increment primary key,
nome varchar(60),
valor decimal(11, 2),
descricao varchar(60),
desconto decimal(11, 2),
valorAposDesconto decimal(11, 2));
```
1. Abra o Eclipse
2. Selecione a pasta do projeto
3. Com o botão direito clique sobre o projeto
4. Selecione "Run as Run on Server"
5. Selecione o Tomcat 10 e execute

# Autor

Gabriel Santos Santana

https://www.linkedin.com/in/gabriel-santos-santana/
