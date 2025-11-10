package br.com.mariolemos.gestao_escolar.model.dto.request;

import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.model.dto.PessoaDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsavelRequest extends PessoaDto {

    private String parentesco;
    @NotBlank(message = "Este campo deve ser preenchido!")
    private List<ContatoRequest> contatos = new ArrayList<ContatoRequest>();

    public static Responsavel of(ResponsavelRequest responsavelRequest) {

        Responsavel responsavel = new Responsavel();

        responsavel.setId(responsavelRequest.getId());
        responsavel.setNome(responsavelRequest.getNome());
        responsavel.setCpf(responsavelRequest.getCpf());
        responsavel.setRg(responsavelRequest.getRg());
        responsavel.setParentesco(responsavelRequest.getParentesco());
        responsavel.setDataNascimento(responsavelRequest.getDataNascimento());

        return responsavel;

    }

}
