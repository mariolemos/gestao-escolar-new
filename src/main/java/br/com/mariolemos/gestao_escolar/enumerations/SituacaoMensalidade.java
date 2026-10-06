package br.com.mariolemos.gestao_escolar.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SituacaoMensalidade {



    PAGA(0, "PAGA"),
    PENDENTE(1, "PENDENTE"),
    ABONADA(2, "ABONADA"),
    ATRASADA(3, "ATRASADA");

    private Integer id;
    private String descricao;

    public static br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade find(Integer id) {
        for (br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade situacao : br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade.values()) {
            if (situacao.getId() == id) {
                return situacao;
            }
        }
        throw new IllegalArgumentException("Situacao mensalidade não encontrada");
    }

    public static br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade find(String descricao) {
        for (br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade situacao : br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade.values()) {
            if (situacao.getDescricao().equalsIgnoreCase(descricao)) {
                return situacao;
            }
        }
        throw new IllegalArgumentException("Situacao mensalidade não encontrada");
    }

}
