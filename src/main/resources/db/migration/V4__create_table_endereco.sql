create table ENDERECO (
    ID bigint GENERATED ALWAYS AS IDENTITY  not null primary key,
    LOGRADOURO VARCHAR(150) not null,
    NUMERO VARCHAR(15),
    COMPLEMENTO VARCHAR(100),
    BAIRRO VARCHAR(100) not null,
    CEP VARCHAR(15) not null,
    CIDADE VARCHAR(100) not null,
    ESTADO VARCHAR(50) not null,
    COLEGIO_ID bigint,
    PESSOA_ID bigint,

        foreign key (COLEGIO_ID) references COLEGIO(ID),
        foreign key (PESSOA_ID) references PESSOA(ID)
    );

