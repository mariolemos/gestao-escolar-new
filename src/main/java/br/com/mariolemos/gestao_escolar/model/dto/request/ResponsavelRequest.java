package br.com.mariolemos.gestao_escolar.model.dto.request;

import br.com.mariolemos.gestao_escolar.model.Endereco;
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


    @NotBlank
    private String nome;
    @NotBlank
    private String parentesco;
    @NotBlank(message = "Este campo deve ser preenchido!")
    private List<ContatoRequest> contatos = new ArrayList<ContatoRequest>();
    private EnderecoRequest endereco;

    public static Responsavel of(ResponsavelRequest responsavelRequest) {

        Responsavel responsavel = new Responsavel();

        responsavel.setNome(responsavelRequest.getNome());
        responsavel.setCpf(responsavelRequest.getCpf());
        responsavel.setRg(responsavelRequest.getRg());
        responsavel.setParentesco(responsavelRequest.getParentesco());
        responsavel.setDataNascimento(responsavelRequest.getDataNascimento());
        responsavel.setEndereco(EnderecoRequest.of(responsavelRequest.getEndereco()));
        responsavel.setContatos(ContatoRequest.of(responsavelRequest.getContatos()));

        return responsavel;

    }

}
