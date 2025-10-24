create table if not exists `CONTATO`(
    ID bigint not null auto_increment primary key,
        TIPO_CONTATO VARCHAR(10) not null,
        CONTATO VARCHAR(100) not null,
        COLEGIO_ID bigint,
                foreign key (COLEGIO_ID) references COLEGIO(ID)
    );


