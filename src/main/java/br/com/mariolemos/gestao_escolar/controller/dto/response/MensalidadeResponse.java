package br.com.mariolemos.gestao_escolar.controller.dto.response;

import br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade;
import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensalidadeResponse {

    private String mes;
    private String ano;
    private LocalDate dtPagamento;
    private BigDecimal valorMensal;
    private BigDecimal desconto;
    private BigDecimal jurosMora;
    private BigDecimal valorPago;
    private SituacaoMensalidade situacao;
    private Long alunoid;

    public MensalidadeResponse(Mensalidade mensalidade) {

        this.mes = mensalidade.getMes();
        this.ano = mensalidade.getAno();
        this.dtPagamento = mensalidade.getDtPagamento();
        this.valorMensal = mensalidade.getValorMensal();
        this.desconto = mensalidade.getDesconto();
        this.jurosMora = mensalidade.getJurosMora();
        this.situacao = mensalidade.getSituacao();
        this.alunoid = mensalidade.getAluno().getId();
    }

    public static List<MensalidadeResponse> of(List<Mensalidade> mensalidades) {
        return mensalidades.stream().map(MensalidadeResponse::new).collect(Collectors.toList());
    }


}
