package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.exception.RegraDeNegocioException;
import br.com.mariolemos.gestao_escolar.model.Contato;
import br.com.mariolemos.gestao_escolar.model.Endereco;
import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ContatoService contatoService;

    public List<Responsavel> buscar() {
        return responsavelRepository.findAll();
    }

    public Responsavel buscarPorId(Long id) {
        return responsavelRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    public Responsavel incluir(Responsavel responsavel) {
        if(responsavelRepository.existsBycpf(responsavel.getCpf())) {
            throw new RegraDeNegocioException("Este CPF já está cadastrado");
        }
        return responsavelRepository.save(responsavel);
    }

    public Responsavel alterar(Responsavel responsavel, Long id) {

        Responsavel responsavel1 = buscarPorId(id);

        responsavel1.setNome(responsavel.getNome());
        responsavel1.setDataNascimento(responsavel.getDataNascimento());
        responsavel1.setCpf(responsavel.getCpf());
        responsavel1.setRg(responsavel.getRg());
        responsavel1.setParentesco(responsavel.getParentesco());

        List<Contato> contatos = responsavel1.getContatos();
        contatoService.deleteAll(contatos);
        responsavel1.setContatos(responsavel.getContatos());

        if (responsavel.getEndereco() != null) {
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
