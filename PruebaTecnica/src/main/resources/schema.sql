drop table if exists persona;

create table persona (
    tipoDocumento VARCHAR(1),
    numeroDocumento BIGINT,
    primerNombre VARCHAR(250),
    segundoNombre VARCHAR(250),
    primerApellido VARCHAR(250),
    segundoApellido VARCHAR(250),
    telefono BIGINT,
    direccion VARCHAR(250),
    ciudad VARCHAR(250),
    PRIMARY KEY(tipoDocumento, numeroDocumento)
);