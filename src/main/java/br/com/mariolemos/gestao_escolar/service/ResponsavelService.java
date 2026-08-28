package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.configuration.UsuarioLogado;
import br.com.mariolemos.gestao_escolar.exception.BusinessException;
import br.com.mariolemos.gestao_escolar.exception.RegraDeNegocioException;
import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static br.com.mariolemos.gestao_escolar.constrants.Constrants.MSG_USUARIO_SEM_PERMISSAO;
import static br.com.mariolemos.gestao_escolar.constrants.Constrants.PERFIL_RESPONSAVEL;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private UsuarioLogado usuarioLogado;

    public List<Responsavel> buscar() {
        if(usuarioLogado.getPerfil().equalsIgnoreCase(PERFIL_RESPONSAVEL)){
            try{
                return Collections.singletonList(buscarPorCpf(usuarioLogado.getUserName()));
            } catch (BusinessException e) {
                return new ArrayList<>();
            }
        }

        return responsavelRepository.findAll();
    }

    public Responsavel buscarPorId(Long id) {
        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(() -> new BusinessException("Recurso não encontrado"));
        if(!responsavel.getId().equals(buscarPorCpf(usuarioLogado.getUserName()).getId())){
            throw new BusinessException(MSG_USUARIO_SEM_PERMISSAO);
        }
        return responsavel;
    }

    public Responsavel buscarPorCpf(String cpf) {
        return responsavelRepository.findBycpf(cpf).orElseThrow(() -> new BusinessException("Recurso não encontrado"));
    }

    public Responsavel incluir(Responsavel responsavel) {
        if(responsavelRepository.existsBycpf(responsavel.getCpf())) {
            throw new RegraDeNegocioException("Este CPF já está cadastrado");
        }
        return responsavelRepository.save(responsavel);
    }

    public Responsavel alterar(Responsavel responsavel, Long id) {

        Responsavel responsavel1 = buscarPorId(id);

        if(!responsavel.getId().equals(buscarPorCpf(usuarioLogado.getUserName()).getId())){
            throw new BusinessException(MSG_USUARIO_SEM_PERMISSAO);
        }

        responsavel1.setNome(responsavel.getNome());
        responsavel1.setDataNascimento(responsavel.getDataNascimento());
        responsavel1.setCpf(responsavel.getCpf());
        responsavel1.setRg(responsavel.getRg());
        responsavel1.setParentesco(responsavel.getParentesco());

        contatoService.deleteAll(responsavel1.getContatos());
        responsavel1.setContatos(responsavel.getContatos());

        if (responsavel.getEndereco() != null) {
//            responsavel1.setEndereco(new Endereco());
//            responsavel1.getEndereco().setId(responsavel.getEndereco().getId());
            responsavel1.getEndereco().setLogradouro(responsavel.getEndereco().getLogradouro());
            responsavel1.getEndereco().setBairro(responsavel.getEndereco().getBairro());
            responsavel1.getEndereco().setCep(responsavel.getEndereco().getCep());
            responsavel1.getEndereco().setComplemento(responsavel.getEndereco().getComplemento());
            responsavel1.getEndereco().setEstado(responsavel.getEndereco().getEstado());
            responsavel1.getEndereco().setCidade(responsavel.getEndereco().getCidade());
            responsavel1.getEndereco().setNumero(responsavel.getEndereco().getNumero());
        }
        return responsavelRepository.save(responsavel1);
    }

    public Responsavel buscarCpf(String cpf) {
       if(responsavelRepository.existsBycpf(cpf)) {
//           Responsavel responsavel = new Responsavel();
//           responsavel.setCpf(responsavel.getCpf(cpf));
           return buscarCpf(cpf);
       }
       return null;
    }
}
