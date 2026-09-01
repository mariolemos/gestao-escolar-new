alter table endereco add column PESSOA_ID bigint;

alter table endereco add constraint foreign key (PESSOA_ID) references PESSOA(ID);



