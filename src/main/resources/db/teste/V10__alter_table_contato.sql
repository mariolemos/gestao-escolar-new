alter table `Contato` drop constraint contato_ibfk_2;

alter table `Contato` drop column RESPONSAVEL_ID;

alter table `Contato` add column PESSOA_ID bigint;

alter table `Contato` add CONSTRAINT foreign key (PESSOA_ID) references RESPONSAVEL(ID);

