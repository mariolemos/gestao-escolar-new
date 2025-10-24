package br.com.mariolemos.gestao_escolar.model.dto.request;

import br.com.mariolemos.gestao_escolar.enumerations.TipoContato;
import br.com.mariolemos.gestao_escolar.model.Contato;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoRequest {

    private Long id;
    @NotBlank(message = "Contato obrigatório")
    private String contato;
    @NotBlank(message = "Tipo obrigatório")
    private int tipo;

    public static Contato of(ContatoRequest contatoRequest){

        Contato contato = new Contato();

        contato.setContato(contatoRequest.getContato());
        contato.setTipo(TipoContato.find(contatoRequest.getTipo()));
        contato.setId(contatoRequest.getId());

        return contato;
    }

    public static List<Contato> of(List<ContatoRequest> contatos) {
        return contatos.stream().map(ContatoRequest::of).collect(Collectors.toList());
    }
}
