package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.exception.RegraDeNegocioException;
import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {


    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato inativarContrato(Long id) {
        Contrato contrato = new Contrato();
        contrato.setAtivo(false);
        return alterar(id, contrato);
    }

    public List<Contrato> buscar(){

        List<Contrato> contratos = contratoRepository.findAll();
        return contratos;
    }

    public Contrato buscarPorId(Long id){
        Contrato contrato = contratoRepository.findById(id).get();
        return contrato;
    }

    private Contrato alterar(Long id, Contrato contrato) {
        Contrato contratoExistente = buscarPorId(id);
        contratoExistente.setAtivo(contrato.getAtivo());
        return contratoRepository.save(contratoExistente);
    }

    public Contrato incluir(Contrato contrato) {
        Long responsavelId = contrato.getResponsavel().getId();
        boolean possuiContratoAtivo = contratoRepository.existsByResponsavelIdAndAtivo(responsavelId, contrato.getAtivo());
        if (possuiContratoAtivo) {
            throw new RegraDeNegocioException("Este responsávbel já possui um contrato ativo.");
        }
        contrato.calcularMensalidade();
        return contratoRepository.save(contrato);
    }
}
