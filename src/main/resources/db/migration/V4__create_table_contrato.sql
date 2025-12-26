create table `CONTRATO`(
        ID bigint not null auto_increment primary key,
        VALOR_CONTRATUAL DOUBLE,
        DATA_PAGAMENTO DATE,
        FORMA_PAGAMENTO VARCHAR(15),
        DATA_INICIAL DATE,
        DATA_FINAL DATE,
        ATIVO BOOLEAN,
        TIPO_CONTATO VARCHAR(10),
        CONTATO VARCHAR(100),
        DIA_PAGAMENTO INTEGER,
        VALOR_MENSAL FLOAT
    );


