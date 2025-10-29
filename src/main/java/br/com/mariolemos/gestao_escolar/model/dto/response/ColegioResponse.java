package br.com.mariolemos.gestao_escolar.model.dto.response;
import br.com.mariolemos.gestao_escolar.model.Colegio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColegioResponse {

    private Long id;
    private String nome;
    private String horario;
    private List<ContatoResponse> contatos = new ArrayList<>();
    private EnderecoResponse endereco;

    public ColegioResponse(Colegio colegio){
        this.id = colegio.getId();
        this.nome = colegio.getNome();
        this.horario = colegio.getHorario();
        this.contatos = ContatoResponse.of(colegio.getContatos());
        this.endereco = EnderecoResponse.of(colegio.getEndereco());
    }

    public static List<ColegioResponse> of(List<Colegio> colegios){
        return colegios.stream().map(ColegioResponse::new).collect(Collectors.toList());
    }
}
