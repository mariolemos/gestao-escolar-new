package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.enumerations.FormaPagamento;
import br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade;
import br.com.mariolemos.gestao_escolar.exception.RegraDeNegocioException;
import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import br.com.mariolemos.gestao_escolar.repository.MensalidadeRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

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

        mensalidade.setValorMensal(contrato1.calcularValorMensal());
        mensalidade.calcularValorPago();
        mensalidade.setValorPago(mensalidade.calcularValorPago());
        mensalidade.setAno(ano.toString());
        mensalidade.setMes(mes.getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));
        return mensalidadeRepository.save(mensalidade);
    }

    public List<Mensalidade> buscar() {
        return mensalidadeRepository.findAll();
    }

    public Mensalidade buscarPorId(Long id) {
        return mensalidadeRepository.findById(id).get();
    }

    public Mensalidade pagarMensalidade(Mensalidade mensalidade, Long mensalidadeId) {
        Mensalidade mensaldiade1 = buscarPorId(mensalidadeId);

        if(mensaldiade1 != null) {
            mensaldiade1.setJurosMora(mensalidade.getJurosMora());
            mensaldiade1.setDesconto(mensalidade.getDesconto());
            mensaldiade1.setValorPago(mensaldiade1.calcularValorPago());
            mensaldiade1.setDtPagamento(mensalidade.getDtPagamento());
            mensaldiade1.setSituacao(SituacaoMensalidade.PAGA);
            mensaldiade1.setFormaPagamento(FormaPagamento.find(mensalidade.getFormaPagamento().getId()));
            return mensalidadeRepository.save(mensaldiade1);
        }else {
            throw new RegraDeNegocioException("Mensalidade não encontrada");
        }

    }

    public Mensalidade abonarMensalidade(Mensalidade mensalidade, Long mensalidadeId) {
        Mensalidade mensaldiade1 = buscarPorId(mensalidadeId);
        if (mensaldiade1.getId() != null) {
            if (mensaldiade1.getSituacao().getDescricao() == "ATRASADA" || mensaldiade1.getSituacao().getDescricao() == "PENDENTE") {
                mensaldiade1.setValorMensal(BigDecimal.valueOf(0.0));
                mensaldiade1.setJurosMora(BigDecimal.valueOf(0.0));
                mensaldiade1.setDesconto(BigDecimal.valueOf(0.0));
                mensaldiade1.setValorPago(BigDecimal.valueOf(0.0));
                mensaldiade1.setSituacao(SituacaoMensalidade.ABONADA);
            } else if (mensaldiade1.getSituacao().getDescricao() == "PAGA") {
                throw new RegraDeNegocioException("Mensalidades Pagas não podem ser Abonadas");
            } else {
                throw new RegraDeNegocioException("Mensalidade já se encontra abonada");
            }
        }else {
            throw new RegraDeNegocioException("Mensalidade não encontrada");
        }
        return mensalidadeRepository.save(mensaldiade1);
    }
}
