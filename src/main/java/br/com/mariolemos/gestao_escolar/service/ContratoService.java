package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.exception.RegraDeNegocioException;
import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import br.com.mariolemos.gestao_escolar.repository.ContratoRepository;
import br.com.mariolemos.gestao_escolar.repository.MensalidadeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ContratoService {


    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

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

    @Transactional
    public Contrato incluir(Contrato contrato) {
        Long responsavelId = contrato.getResponsavel().getId();
        boolean possuiContratoAtivo = contratoRepository.existsByResponsavelIdAndAtivo(responsavelId, contrato.getAtivo());
        if (possuiContratoAtivo) {
            throw new RegraDeNegocioException("Este responsável já possui um contrato ativo.");
        }
        contrato.calcularValorMensal();
        Contrato contratoNovo = contratoRepository.save(contrato);
        gerarMensalidade(contratoNovo);
        return contratoNovo;
    }

    public void gerarMensalidade(@NotNull Contrato contrato) {

        List<Mensalidade> mensalidades = new ArrayList<>();

        for (int i = 1; i <= contrato.calcularQtdoParcelas() ; i++) {
            Mensalidade mensalidade = new Mensalidade();

            Year ano = Year.from(contrato.getDataInicial());
            Month mes = Month.from(contrato.getDataInicial());

            mensalidade.setValorMensal(contrato.getValorMensal());
            mensalidade.setAno(ano.toString());
            mensalidade.setContrato(mensalidade.getContrato());
            mensalidade.setMes(mes.getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));
            mensalidade.setContrato(contrato);
            mensalidades.add(mensalidade);
        }

        mensalidadeRepository.saveAll(mensalidades);
    }
}
