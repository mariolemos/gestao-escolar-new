create table if not exists COLEGIO(
    ID bigint GENERATED ALWAYS AS IDENTITY not null primary key,
    NOME VARCHAR(100),
    HORARIO varchar(15)
    );
