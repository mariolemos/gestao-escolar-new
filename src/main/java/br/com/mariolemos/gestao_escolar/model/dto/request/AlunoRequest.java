package br.com.mariolemos.gestao_escolar.model.dto.request;

import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.Colegio;
import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.model.dto.PessoaDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest extends PessoaDto {
    private String turno;
    private String serie;
    private String turma;
    private String nomePai;
    private String nomeMae;
    @NotNull
    private Boolean ativo;
    private String convenioMedico;
    @NotNull
    private Long colegioId;
    @NotNull
    private Long responsavelId;
    private List<ContatoRequest> contatos = new ArrayList<ContatoRequest>();

    public static Aluno Of(AlunoRequest alunoRequest) {

        Aluno aluno = new Aluno();

        Responsavel responsavel = new Responsavel();
        responsavel.setId(alunoRequest.getResponsavelId());

        Colegio colegio = new Colegio();
        colegio.setId(alunoRequest.getColegioId());

       aluno.setNome(alunoRequest.getNome());
       aluno.setCpf(alunoRequest.getCpf());
       aluno.setRg(alunoRequest.getRg());
       aluno.setDataNascimento(alunoRequest.getDataNascimento());
       aluno.setTurno(alunoRequest.getTurno());
       aluno.setSerie(alunoRequest.getSerie());
       aluno.setTurma(alunoRequest.getTurma());
       aluno.setNomePai(alunoRequest.getNomePai());
       aluno.setNomeMae(alunoRequest.getNomeMae());
       aluno.setAtivo(alunoRequest.getAtivo());
       aluno.setConvenioMedico(alunoRequest.getConvenioMedico());
       aluno.setColegio(colegio);
       aluno.setResponsavel(responsavel);

       return aluno;
    }

    public static List<Aluno> of(List<AlunoRequest> alunosRequest) {
        return alunosRequest.stream().map(AlunoRequest::Of).collect(Collectors.toList());
    }
}
