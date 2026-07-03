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
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTRATO")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "VALOR_CONTRATUAL")
    private BigDecimal valorContratual;
    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dataPagamento;
    @Column(name = "FORMA_PAGAMENTO")
    @Enumerated(value = EnumType.STRING)
    private FormaPagamento formaPagamento;
    @Column(name = "DATA_INICIAL")
    private LocalDate dataInicial;
    @Column(name = "DATA_FINAL")
    private LocalDate dataFinal;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @Column(name = "DIA_PAGAMENTO")
    private Integer diaPagamento;
    @Column(name = "VALOR_MENSAL")
    private BigDecimal valorMensal;
    @Column(name = "VALOR_DESCONTO")
    private BigDecimal valorDesconto;
    @Column(name = "DATA_INATIVACAO")
    private LocalDate dataInativacao;
    @ManyToOne()
    @JoinColumn(name = "RESPONSAVEL_Id")
    private Responsavel responsavel;
    @OneToMany
    private List<Aluno> alunos = new ArrayList<>();

    public void calcularMensalidade() {
        int parcelas = dataFinal.getMonthValue() - dataInicial.getMonthValue() + 1;
        BigDecimal mensalidade = valorContratual;
        this.valorMensal = mensalidade.divide(new BigDecimal(parcelas), 2, RoundingMode.HALF_UP);
    }
}
