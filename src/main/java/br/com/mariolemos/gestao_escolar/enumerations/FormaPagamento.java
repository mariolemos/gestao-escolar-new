package br.com.mariolemos.gestao_escolar.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum FormaPagamento {

    AVISTA(0, "AVISTA"),
    PIX(1, "PIX"),
    CARTAO(2, "CARTÃO"),
    TRANSFERENCIA(3, "TRANSFERÊNCIA");

    private Integer id;
    private String descricao;

    public static FormaPagamento find(Integer id){
        for (FormaPagamento tipoContato : FormaPagamento.values()) {
            if(tipoContato.getId() == id){
                return tipoContato;
            }
        }
        throw new IllegalArgumentException("FormaPagamento não encontrada");
    }

    public static FormaPagamento find(String descricao){
        for (FormaPagamento tipoContato : FormaPagamento.values()) {
            if(tipoContato.getDescricao().equalsIgnoreCase(descricao)){
                return tipoContato;
            }
        }
        throw new IllegalArgumentException("FormaPagamento não encontrada");
    }
}
