create table MENSALIDADE(

    ID bigint GENERATED ALWAYS AS IDENTITY  not null primary key,
    VALOR_MENSAL decimal,
    VALOR_DESCONTO decimal,
    VALOR_JUROS decimal,
    VALOR_PAGO decimal,
    DATA_PAGAMENTO DATE,
    FORMA_PAGAMENTO varchar(20),
    SITUACAO VARCHAR(20),
    MES VARCHAR(20),
    ANO VARCHAR(20),

    ALUNO_ID bigint,

    FOREIGN KEY (ALUNO_ID) REFERENCES ALUNO(ID)

    );