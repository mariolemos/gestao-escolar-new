package br.com.mariolemos.gestao_escolar.service;


import br.com.mariolemos.gestao_escolar.configuration.UsuarioLogado;
import br.com.mariolemos.gestao_escolar.constrants.Constrants;
import br.com.mariolemos.gestao_escolar.exception.BusinessException;
import br.com.mariolemos.gestao_escolar.exception.RegraDeNegocioException;
import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.model.Contato;
import br.com.mariolemos.gestao_escolar.repository.AlunoRepository;
import br.com.mariolemos.gestao_escolar.repository.ColegioRepository;
import br.com.mariolemos.gestao_escolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static br.com.mariolemos.gestao_escolar.constrants.Constrants.MSG_USUARIO_SEM_PERMISSAO;
import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private UsuarioLogado usuarioLogado;

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public List<Aluno> buscar(){
        if(usuarioLogado.getPerfil().equalsIgnoreCase(Constrants.PERFIL_RESPONSAVEL)){
            try{
                return buscarListAlunoPorResponsavelCpf(usuarioLogado.getUserName());
            } catch (BusinessException e) {
                return new ArrayList<>();
            }
        }
        List<Aluno> alunos = alunoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));

        return alunos;
    }

    public Aluno buscarPorCpf(String cpf) {
        return alunoRepository.findBycpf(cpf).orElseThrow(() -> new BusinessException("Recurso não encontrado"));
    }

    public List<Aluno> buscarListAlunoPorResponsavelCpf(String cpf) {
        return alunoRepository.findAllByResponsavelCpf(cpf);
    }

    public Aluno buscarAlunoPorResponsavelCpf(String cpf) {
        return alunoRepository.findByResponsavelCpf(cpf).orElseThrow(() -> new BusinessException("Recurso não encontrado"));
    }


    public Aluno buscarPorId(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new BusinessException("Recurso não encontrado"));

        if(usuarioLogado.getPerfil().equalsIgnoreCase(Constrants.PERFIL_RESPONSAVEL)){
            try{
                return buscarAlunoPorResponsavelCpf(usuarioLogado.getUserName());
            } catch (BusinessException e) {
                throw new BusinessException(MSG_USUARIO_SEM_PERMISSAO);
            }
        }

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

        List<Contato> contatos = alunoAtualizado.getContatos();
        contatoService.deleteAll(contatos);
        alunoAtualizado.setContatos(aluno.getContatos());


        if(aluno.getEndereco() != null) {
            alunoAtualizado.getEndereco().setCep(aluno.getEndereco().getCep());
            alunoAtualizado.getEndereco().setLogradouro(aluno.getEndereco().getLogradouro());
            alunoAtualizado.getEndereco().setNumero(aluno.getEndereco().getNumero());
            alunoAtualizado.getEndereco().setComplemento(aluno.getEndereco().getComplemento());
            alunoAtualizado.getEndereco().setBairro(aluno.getEndereco().getBairro());
            alunoAtualizado.getEndereco().setCidade(aluno.getEndereco().getCidade());
            alunoAtualizado.getEndereco().setEstado(aluno.getEndereco().getEstado());
        }
        return alunoRepository.save(alunoAtualizado);
    }

    public void excluir(Long id){
        alunoRepository.deleteById(id);
    }
}
