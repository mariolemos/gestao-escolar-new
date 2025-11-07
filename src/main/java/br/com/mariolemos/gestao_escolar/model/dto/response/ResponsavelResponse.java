package br.com.mariolemos.gestao_escolar.model.dto.response;

import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.model.Pessoa;
import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.model.dto.PessoaDto;
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
    private List<Contrato> contratos = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public ResponsavelResponse of(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.parentesco = responsavel.getParentesco();

        super.setNome(responsavel.getNome());
        super.setRg(responsavel.getRg());
        super.setCpf(responsavel.getCpf());
        super.setDataNascimento(responsavel.getDataNascimento());

        if (responsavel.getContratos() != null) {
            this.contratos = responsavel.getContratos();
        }

        if (responsavel.getAlunos() != null) {
            this.alunos = responsavel.getAlunos();
        }
        return null;

    }

//    public static List<ResponsavelResponse> of(List<Responsavel> responsaveis) {
//        return responsaveis.stream().map(Responsavel resp -> new ResponsavelResponse(resp)).collect(Collectors.toList());
//    }


}
