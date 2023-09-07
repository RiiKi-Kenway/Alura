CREATE TABLE consultas(
    consultaid bigint NOT NULL PRIMARY KEY auto_increment,
    medicoid bigint NOT NULL,
    pacienteid bigint NOT NULL,
    data datetime NOT NULL,

    CONSTRAINT fk_consultas_medicoid FOREIGN KEY(medicoid) REFERENCES medicos(medicoid),
    CONSTRAINT fk_consultas_pacienteid FOREIGN KEY(pacienteid) REFERENCES pacientes(pacienteid)
);