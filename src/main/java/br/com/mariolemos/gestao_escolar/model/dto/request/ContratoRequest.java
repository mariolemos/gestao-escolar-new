package br.com.mariolemos.gestao_escolar.model.dto.request;

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
public class ContratoRequest {
    private Long id;
    private BigDecimal valorContratual;
    private LocalDate dtPagamento;
    private int formaPagamento;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private Boolean ativo;
    private Integer diaPagamento;

    public  static Contrato of(ContratoRequest contratoRequest){

        Contrato contrato = new Contrato();
        contrato.setValorContratual(contratoRequest.getValorContratual());
        contrato.setDtPagamento(contratoRequest.getDtPagamento());
        contrato.setFormaPagamento(FormaPagamento.find(contratoRequest.getFormaPagamento()));
        contrato.setDtInicial(contratoRequest.getDtInicial());
        contrato.setDtFinal(contratoRequest.getDtFinal());
        contrato.setAtivo(contratoRequest.getAtivo());
        contrato.setDiaPagamento(contratoRequest.getDiaPagamento());
        return contrato;
    }

    public static List<Contrato> of(List<ContratoRequest> contratos){
        return  contratos.stream().map(ContratoRequest::of).collect(Collectors.toList());
    }
}
