package br.com.mariolemos.gestao_escolar.service;


import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.repository.AlunoRepository;
import br.com.mariolemos.gestao_escolar.repository.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscar(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id){
        Aluno aluno = alunoRepository.findById(id).get();
        return aluno;
    }

    public Aluno incluir(Aluno aluno){
        alunoRepository.save(aluno);
        return aluno;
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

        alunoRepository.save(alunoAtualizado);

        return alunoAtualizado;
    }

    public void excluir(Long id){
        alunoRepository.deleteById(id);
    }
}
