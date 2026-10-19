package br.com.mariolemos.gestao_escolar.model;

import br.com.mariolemos.gestao_escolar.enumerations.FormaPagamento;
import br.com.mariolemos.gestao_escolar.enumerations.SituacaoMensalidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MENSALIDADE")
public class Mensalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "MES")
    private String mes;
    @Column(name = "ANO")
    private String ano;
    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dtPagamento;
    @Column(name = "VALOR_MENSAL")
    private BigDecimal valorMensal = new BigDecimal(0);
    @Column(name = "VALOR_DESCONTO")
    private BigDecimal desconto;
    @Column(name = "VALOR_JUROS")
    private BigDecimal jurosMora;
    @Column(name = "VALOR_PAGO")
    private BigDecimal valorPago;
    @Column(name = "SITUACAO")
    @Enumerated(EnumType.STRING)
    private SituacaoMensalidade situacao = SituacaoMensalidade.PENDENTE;
    @Column(name = "FORMA_PAGAMENTO")
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRATO_ID")
    private Contrato contrato;

    public BigDecimal calcularValorPago() {
        this.valorPago = this.valorMensal.subtract(this.desconto).add(this.jurosMora);
        return valorPago;
    }
}
