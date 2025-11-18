package br.com.mariolemos.gestao_escolar.model;


import br.com.mariolemos.gestao_escolar.enumerations.FormaPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "CONTRATO")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "VALOR_CONTRATUAL")
    private BigDecimal valorContratual;
    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dtPagamento;
    @Column(name = "FORMA_PAGAMENTO")
    @Enumerated(value = EnumType.STRING)
    private FormaPagamento formaPagamento;
    @Column(name = "DATA_INICIAL")
    private LocalDate dtInicial;
    @Column(name = "DATA_FINAL")
    private LocalDate dtFinal;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @Column(name = "DIA_PAGAMENTO")
    private Integer diaPagamento;
    @Column(name = "VALOR_MENSAL")
    private BigDecimal valorMensal;
//    @ManyToOne
//    private Responsavel responsavel;

    public void calcularMensalidade() {
        int parcelas = dtFinal.getMonthValue() - dtInicial.getMonthValue() + 1;
        BigDecimal mensalidade = valorContratual;
        this.valorMensal = mensalidade.divide(new BigDecimal(parcelas), 2, RoundingMode.HALF_UP);
    }
}
