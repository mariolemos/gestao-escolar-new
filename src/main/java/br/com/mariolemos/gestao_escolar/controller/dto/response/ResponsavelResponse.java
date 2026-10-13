package br.com.mariolemos.gestao_escolar.controller.dto.response;

import br.com.mariolemos.gestao_escolar.model.*;
import br.com.mariolemos.gestao_escolar.controller.dto.PessoaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsavelResponse extends PessoaDto {

    private Long id;
    private String parentesco;
    private List<ContatoResponse> contatos = new ArrayList<>();
    private List<AlunoResponse> alunos = new ArrayList<>();
    private EnderecoResponse endereco;

    public ResponsavelResponse(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.parentesco = responsavel.getParentesco();
        this.contatos = ContatoResponse.of(responsavel.getContatos());
        if(responsavel.getEndereco() != null) {
            this.endereco = EnderecoResponse.of(responsavel.getEndereco());
        }
        this.alunos = AlunoResponse.of(responsavel.getAlunos());
        super.setNome(responsavel.getNome());
        super.setRg(responsavel.getRg());
        super.setCpf(responsavel.getCpf());
        super.setDataNascimento(responsavel.getDataNascimento());

    }

    public static List<ResponsavelResponse> of(List<Responsavel> responsaveis) {
        return responsaveis.stream().map(ResponsavelResponse::new).collect(Collectors.toList());
    }


}
