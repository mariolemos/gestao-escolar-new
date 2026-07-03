create table `PESSOA`(
    ID bigint not null auto_increment primary key,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    CPF VARCHAR(15) not null,
    RG VARCHAR(30)
);
