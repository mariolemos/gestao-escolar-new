alter table `Contato` add column RESPONSAVEL_ID bigint;

alter table `Contato` add CONSTRAINT foreign key (RESPONSAVEL_ID) references RESPONSAVEL(ID);

