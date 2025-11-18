package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public List<Responsavel> buscar () {
        return responsavelRepository.findAll();
    }

    public Responsavel buscarPorId ( Long id){
        return responsavelRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    public Responsavel incluir (Responsavel responsavel) {

        return responsavelRepository.save(responsavel);
    }

    public Responsavel alterar (Responsavel responsavel, Long id) {
        Responsavel responsavel1 = buscarPorId(id);

        responsavel1.setNome(responsavel.getNome());
        responsavel1.setDataNascimento(responsavel.getDataNascimento());
        responsavel1.setCpf(responsavel.getCpf());
        responsavel1.setRg(responsavel.getRg());
        responsavel1.setParentesco(responsavel.getParentesco());
        responsavel1.setContatos(responsavel.getContatos());
        responsavel1.setEndereco(responsavel.getEndereco());

        return responsavelRepository.save(responsavel);

    }

}
