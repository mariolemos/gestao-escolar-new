package br.com.mariolemos.gestao_escolar.model.dto.response;

import br.com.mariolemos.gestao_escolar.model.Colegio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColegioResponse {

    private Long id;
    private String nome;
    private String horario;

    public ColegioResponse(Colegio colegio){
        this.id = colegio.getId();
        this.nome = colegio.getNome();
        this.horario = colegio.getHorario();
    }
}
