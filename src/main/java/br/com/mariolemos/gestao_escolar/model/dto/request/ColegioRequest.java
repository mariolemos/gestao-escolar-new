package br.com.mariolemos.gestao_escolar.model.dto.request;

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
public class ColegioRequest {

    private Long id;
    private String nome;
    private LocalTime horario;
   // private List<Contato> contatos = new ArrayList<>();
  //  private Endereco endereco;

    public static Colegio of(ColegioRequest colegioRequest){

        Colegio colegio = new Colegio();

        colegio.setNome(colegioRequest.getNome());
        colegio.setHorario(colegioRequest.getHorario());

        return colegio;

    }

}
