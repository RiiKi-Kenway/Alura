CREATE TABLE usuarios(
    usuarioid bigint NOT NULL PRIMARY KEY auto_increment,
    login varchar(100) NOT NULL,
    senha varchar(255) NOT NULL
);