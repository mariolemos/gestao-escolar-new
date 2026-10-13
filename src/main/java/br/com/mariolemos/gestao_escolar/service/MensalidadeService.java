package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import br.com.mariolemos.gestao_escolar.repository.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;
import java.util.List;

@Service
public class MensalidadeService {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    @Autowired
    private ContratoService contratoService;

    public Mensalidade incluir(Mensalidade mensalidade, Long contratoId) {
        Contrato contrato1 = contratoService.buscarPorId(contratoId);
        Year ano = Year.from(contrato1.getDataInicial());
        Month mes = Month.from(contrato1.getDataInicial());
//        contrato1.calcularValorMensal();
        mensalidade.setValorMensal(contrato1.calcularValorMensal());
        mensalidade.calcularValorPago();
        mensalidade.setValorPago(mensalidade.calcularValorPago());
        mensalidade.setAno(ano.toString());
        mensalidade.setMes(mes.toString());

        return mensalidadeRepository.save(mensalidade);
    }

    public List<Mensalidade> buscar() {
        return mensalidadeRepository.findAll();
    }
}
