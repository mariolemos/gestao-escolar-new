alter table mensalidade
    drop column ALUNO_Id,
    add column CONTRATO_ID bigint,
add constraint fk_contrato_contrato
foreign key (CONTRATO_ID) references CONTRATO(ID)