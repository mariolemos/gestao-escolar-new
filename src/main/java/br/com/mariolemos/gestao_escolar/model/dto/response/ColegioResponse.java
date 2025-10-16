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
    private LocalTime horario;
    private String aluno;
//    private List<Contato> contatos = new ArrayList<>();
//    private Endereco endereco;

    public ColegioResponse(Colegio colegio){
        this.id = colegio.getId();
        this.nome = colegio.getNome();
        this.horario = colegio.getHorario();
        this.horario = colegio.getHorario();
//        this.contatos = colegio.getContatos();
//        this.endereco = colegio.getEndereco();

    }
}
