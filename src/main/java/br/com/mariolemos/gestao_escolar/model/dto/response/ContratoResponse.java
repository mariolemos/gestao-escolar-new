package br.com.mariolemos.gestao_escolar.model.dto.response;

import br.com.mariolemos.gestao_escolar.enumerations.FormaPagamento;
import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.model.Responsavel;
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
    private LocalDate dataPagamento;
    private FormaPagamento formaPagamento;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Boolean ativo;
    private BigDecimal valorMensal;
    private Integer diaPagamento;
    private Long responsavelId;
    private String nomeResponsavel;

    public ContratoResponse(Contrato contrato) {
        this.id = contrato.getId();
        this.valorContratual = contrato.getValorContratual();
        this.dataPagamento = contrato.getDataPagamento();
        this.formaPagamento = contrato.getFormaPagamento();
        this.dataInicial = contrato.getDataInicial();
        this.dataFinal = contrato.getDataFinal();
        this.ativo = contrato.getAtivo();
        this.valorMensal = contrato.getValorMensal();
        this.diaPagamento = contrato.getDiaPagamento();
        this.responsavelId = contrato.getResponsavel().getId();
        this.nomeResponsavel = contrato.getResponsavel().getNome();
    }

    public static List<ContratoResponse> of(List<Contrato> contratos) {
        return contratos.stream().map(ContratoResponse::new).collect(Collectors.toList());
    }

}
