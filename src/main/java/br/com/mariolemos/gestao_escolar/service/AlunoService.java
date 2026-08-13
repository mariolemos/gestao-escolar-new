package br.com.mariolemos.gestao_escolar.service;


import br.com.mariolemos.gestao_escolar.exception.RegraDeNegocioException;
import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.repository.AlunoRepository;
import br.com.mariolemos.gestao_escolar.repository.ColegioRepository;
import br.com.mariolemos.gestao_escolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public List<Aluno> buscar(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id){
        Aluno aluno = alunoRepository.findById(id).get();
        return aluno;
    }

    public Aluno incluir(Aluno aluno){

        if(alunoRepository.existsBycpf(aluno.getCpf())) {
            throw new RegraDeNegocioException("Este CPF já está cadastrado");
        }
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Aluno aluno, Long id){
        Aluno alunoAtualizado = buscarPorId(id);
        alunoAtualizado.setNome(aluno.getNome());
        alunoAtualizado.setRg(aluno.getRg());
        alunoAtualizado.setCpf(aluno.getCpf());
        alunoAtualizado.setDataNascimento(aluno.getDataNascimento());
        alunoAtualizado.setAtivo(aluno.getAtivo());
        alunoAtualizado.setTurno(aluno.getTurno());
        alunoAtualizado.setTurma(aluno.getTurma());
        alunoAtualizado.setSerie(aluno.getSerie());
        alunoAtualizado.setNomePai(aluno.getNomePai());
        alunoAtualizado.setNomeMae(aluno.getNomeMae());
        alunoAtualizado.setConvenioMedico(aluno.getConvenioMedico());
        alunoAtualizado.setColegio(aluno.getColegio());
        alunoAtualizado.setResponsavel(aluno.getResponsavel());
        alunoAtualizado.setEndereco(aluno.getEndereco());

        alunoRepository.save(alunoAtualizado);

        return alunoAtualizado;
    }

    public void excluir(Long id){
        alunoRepository.deleteById(id);
    }
}
