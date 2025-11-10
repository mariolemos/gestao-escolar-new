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

    public Responsavel incluir (Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public Responsavel alterar (Responsavel responsavel) {
        return responsavelRepository.save(responsavel);

    }

}
