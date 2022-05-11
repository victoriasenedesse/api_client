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
CREATE TABLE endereco(
    id int AUTO_INCREMENT,
    cep varchar(8) NOT NULL,
    rua varchar(50) NOT NULL,
    bairro varchar(50) NOT NULL,
    numero int NOT NULL,
    cidade varchar(50) NOT NULL,
    uf varchar(2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cliente(
    id int NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    cpf varchar(20) NOT NULL,
    sexo varchar(20) NOT NULL,
    nascimento date NOT NULL,
    endereco_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (endereco_id) REFERENCES endereco (id)
);
