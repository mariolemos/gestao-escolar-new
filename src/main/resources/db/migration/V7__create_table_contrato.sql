create table `CONTRATO`(

    ID bigint not null auto_increment primary key,
    VALOR_CONTRATUAL DECIMAL,
    DATA_PAGAMENTO DATE,
    FORMA_PAGAMENTO varchar(20),
    DATA_INICIAL DATE,
    DATA_FINAL DATE,
    ATIVO boolean,
    DIA_PAGAMENTO integer,
    VALOR_MENSAL DECIMAL,

    RESPONSAVEL_ID bigint,

    FOREIGN KEY (RESPONSAVEL_ID) REFERENCES RESPONSAVEL(ID)

    );