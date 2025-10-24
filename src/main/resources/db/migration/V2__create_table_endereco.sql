create table if not exists `ENDERECO` (
    ID bigint not null auto_increment primary key,
    LOGRADOURO VARCHAR(150) not null,
    NUMERO VARCHAR(15),
    COMPLEMENTO VARCHAR(100),
    BAIRRO VARCHAR(100) not null,
    CEP VARCHAR(15) not null,
    CIDADE VARCHAR(100) not null,
    ESTADO VARCHAR(50) not null,
    COLEGIO_ID bigint,
        foreign key (COLEGIO_ID) references COLEGIO(ID)
    );

