create table `RESPONSAVEL`(
    ID bigint not null auto_increment primary key,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    CPF VARCHAR(15),
    RG VARCHAR(30),
    PARENTESCO VARCHAR(50)
);

