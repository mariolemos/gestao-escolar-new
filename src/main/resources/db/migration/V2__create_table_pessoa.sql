create table PESSOA(
    ID bigint GENERATED ALWAYS AS IDENTITY  not null primary key,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    CPF VARCHAR(15) not null,
    RG VARCHAR(30)
);
