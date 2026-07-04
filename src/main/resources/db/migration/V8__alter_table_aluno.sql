alter table ALUNO
    add column CONTRATO_ID bigint,
	ADD CONSTRAINT fk_aluno_contrato
    FOREIGN KEY (CONTRATO_ID) REFERENCES CONTRATO(ID);