package br.com.mariolemos.gestao_escolar.model.dto.request;

import br.com.mariolemos.gestao_escolar.model.Colegio;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColegioRequest {


    @Max(30)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "O horário não pode estar vazio")
    @Pattern(
            regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]",
            message = "O horário deve estar no formato HH:mm (ex: 10:30)"
    )
    private String horario;

    public static Colegio of(ColegioRequest colegioRequest){

        Colegio colegio = new Colegio();

        colegio.setNome(colegioRequest.getNome());
        colegio.setHorario(colegioRequest.getHorario());

        return colegio;

    }

}
