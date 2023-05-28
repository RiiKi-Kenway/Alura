CREATE TABLE medicos(
    medicoid bigint NOT NULL PRIMARY KEY auto_increment,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    crm varchar(100) NOT NULL UNIQUE,
    especialidade varchar(100) NOT NULL,
    logradouro varchar(100) NOT NULL,
    bairro varchar(100) NOT NULL,
    cep varchar(100) NOT NULL,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) NOT NULL,
    cidade varchar(100) NOT NULL
);