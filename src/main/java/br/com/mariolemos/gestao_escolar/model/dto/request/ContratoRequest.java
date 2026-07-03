package br.com.mariolemos.gestao_escolar.model.dto.request;

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
public class ContratoRequest {
    private Long id;
    private BigDecimal valorContratual;
    private LocalDate dataPagamento;
    private int formaPagamento;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Boolean ativo;
    private Integer diaPagamento;
    private Long responsavelId;

    public  static Contrato of(ContratoRequest contratoRequest){

        Responsavel responsavel = new Responsavel();
        responsavel.setId(contratoRequest.getResponsavelId());


        Contrato contrato = new Contrato();
        contrato.setValorContratual(contratoRequest.getValorContratual());
        contrato.setDataPagamento(contratoRequest.getDataPagamento());
        contrato.setFormaPagamento(FormaPagamento.find(contratoRequest.getFormaPagamento()));
        contrato.setDataInicial(contratoRequest.getDataInicial());
        contrato.setDataFinal(contratoRequest.getDataFinal());
        contrato.setAtivo(contratoRequest.getAtivo());
        contrato.setDiaPagamento(contratoRequest.getDiaPagamento());
        contrato.setResponsavel(responsavel);
        return contrato;
    }

    public static List<Contrato> of(List<ContratoRequest> contratos){
        return  contratos.stream().map(ContratoRequest::of).collect(Collectors.toList());
    }
}
