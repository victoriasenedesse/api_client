-- Apagar o banco de dados
drop database banco;
-- Criar o banco de dados
create database banco;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON banco.* TO 'root' @'localhost';
-- Acesar o banco de dados: banco
USE banco;
-- Criar a tabela: usuario
CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    cpf varchar(20) NOT NULL,
    sexo varchar(20) NOT NULL,
    nascimento date,
    PRIMARY KEY (id)
);