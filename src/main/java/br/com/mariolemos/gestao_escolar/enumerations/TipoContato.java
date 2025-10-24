package br.com.mariolemos.gestao_escolar.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoContato {

    FIXO(0, "FIXO"),
    CELULAR(1, "CELULAR"),
    EMAIL(2, "EMAIL");

    private Integer id;
    private String descricao;

    public static TipoContato find(Integer id){
        for (TipoContato tipoContato : TipoContato.values()) {
            if(tipoContato.getId() == id){
                return tipoContato;
            }
        }
        throw new IllegalArgumentException("TipoContato não encontrado");
    }

    public static TipoContato find(String descricao){
        for (TipoContato tipoContato : TipoContato.values()) {
            if(tipoContato.getDescricao().equalsIgnoreCase(descricao)){
                return tipoContato;
            }
        }
        throw new IllegalArgumentException("TipoContato não encontrado");
    }
}