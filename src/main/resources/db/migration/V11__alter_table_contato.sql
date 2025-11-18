drop table if exists aluno;

drop table if exists contrato;

drop table if exists responsavel;

create table if not exists `PESSOA`(
    ID bigint not null auto_increment primary key,
    NOME VARCHAR(100),
    DATA_NASCIMENTO DATE,
    CPF VARCHAR(15),
    RG VARCHAR(30)
);

create table `RESPONSAVEL`(
    ID bigint not null auto_increment primary key,
    PARENTESCO VARCHAR(50)
);

create table `ALUNO`(

    ID bigint not null auto_increment primary key,
    TURNO varchar(30),
    SERIE VARCHAR(30),
    TURMA VARCHAR(30),
    NOME_DO_PAI varchar(100),
    NOME_DA_MAE VARCHAR(100),
    CONVENIO_MEDICO VARCHAR(50),
    ATIVO boolean,
    COLEGIO_ID bigint,
    RESPONSAVEL_ID bigint,

    FOREIGN KEY (COLEGIO_ID) REFERENCES COLEGIO(ID),
    FOREIGN KEY (RESPONSAVEL_ID) REFERENCES RESPONSAVEL(ID)

    );

    alter table `Contato` add CONSTRAINT foreign key (PESSOA_ID) references PESSOA(ID);






