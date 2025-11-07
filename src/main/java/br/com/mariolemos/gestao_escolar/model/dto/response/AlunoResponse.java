package br.com.mariolemos.gestao_escolar.model.dto.response;

import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.dto.PessoaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponse extends PessoaDto {
    private String turno;
    private String serie;
    private String turma;
    private String nomePai;
    private String nomeMae;
    private String convenioMedico;
    private Boolean ativo;

    public AlunoResponse(Aluno aluno) {

        super.setId(aluno.getId());
        super.setNome(aluno.getNome());
        super.setCpf(aluno.getCpf());
        super.setRg(aluno.getRg());
        super.setDataNascimento(aluno.getDataNascimento());

        this.turno = aluno.getTurno();
        this.serie = aluno.getSerie();
        this.turma = aluno.getTurma();
        this.nomePai = aluno.getNomePai();
        this.nomeMae = aluno.getNomeMae();
        this.convenioMedico = aluno.getConvenioMedico();
        this.ativo = aluno.getAtivo();
    }

    public static List<AlunoResponse> of(List<Aluno> alunos) {
       // return alunos.stream().map(Aluno alu -> new AlunoResponse(alu)).collect(Collectors.toList());
        return alunos.stream().map(AlunoResponse::new).collect(Collectors.toList());
    }


}
