package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import br.com.mariolemos.gestao_escolar.repository.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensalidadeService {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    public Mensalidade incluir(Mensalidade mensalidade) {
        mensalidade.calcularValorPago();
        return mensalidadeRepository.save(mensalidade);
    }

    public List<Mensalidade> buscar(){
        return mensalidadeRepository.findAll();
    }
}
