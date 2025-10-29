package br.com.mariolemos.gestao_escolar.model.dto.response;

import br.com.mariolemos.gestao_escolar.enumerations.FormaPagamento;
import br.com.mariolemos.gestao_escolar.model.Contrato;
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
public class ContratoResponse {

    private Long id;
    private BigDecimal valorContratual;
    private LocalDate dtPagamento;
    private FormaPagamento formaPagamento;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private Boolean ativo;
    private BigDecimal valorMensal;
    private Integer diaPagamento;

    public ContratoResponse(Contrato contrato) {
        this.id = contrato.getId();
        this.valorContratual = contrato.getValorContratual();
        this.dtPagamento = contrato.getDtPagamento();
        this.formaPagamento = contrato.getFormaPagamento();
        this.dtInicial = contrato.getDtInicial();
        this.dtFinal = contrato.getDtFinal();
        this.ativo = contrato.getAtivo();
        this.valorMensal = contrato.getValorMensal();
        this.diaPagamento = contrato.getDiaPagamento();
    }

    public static List<ContratoResponse> of(List<Contrato> contratos) {
        return contratos.stream().map(ContratoResponse::new).collect(Collectors.toList());
    }

}
