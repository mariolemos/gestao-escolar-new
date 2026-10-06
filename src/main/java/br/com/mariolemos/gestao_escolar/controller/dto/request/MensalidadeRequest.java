package br.com.mariolemos.gestao_escolar.controller.dto.request;

import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensalidadeRequest {

    private String mes;
    private String ano;
    private BigDecimal valorMensal;
    private BigDecimal valorDesconto;
    private BigDecimal jurosMora;
    private Long alunoId;

    public  static Mensalidade Of(MensalidadeRequest mensalidadeRequest) {

        Mensalidade mensalidade = new Mensalidade();

        Aluno aluno = new Aluno();
        aluno.setId(mensalidadeRequest.getAlunoId());

        Contrato contrato = new Contrato();

        mensalidade.setMes(mensalidadeRequest.getMes());
        mensalidade.setAno(mensalidadeRequest.getAno());
        mensalidade.setValorMensal(contrato.getValorMensal());
        mensalidade.setDesconto(mensalidadeRequest.getValorDesconto());
        mensalidade.setJurosMora(mensalidadeRequest.getJurosMora());
        mensalidade.setAluno(aluno);

        return mensalidade;
    }

    public static List<Mensalidade> of(List<MensalidadeRequest> mensalidadeRequest) {
        return mensalidadeRequest.stream().map(MensalidadeRequest::Of).collect(Collectors.toList());
    }
}



