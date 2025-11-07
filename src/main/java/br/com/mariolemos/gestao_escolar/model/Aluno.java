package br.com.mariolemos.gestao_escolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALUNO")
public class Aluno extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "TURNO")
    private String turno;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "TURMA")
    private String turma;
    @Column(name = "NOME_DO_PAI")
    private String nomePai;
    @Column(name = "NOME_DA_MAE")
    private String nomeMae;
    @Column(name = "CONVENIO_MEDICO")
    private String convenioMedico;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @ManyToOne
    private Colegio colegio;
    @ManyToOne
    @JoinColumn(name = "RESPONSAVEL_ID")
    private Responsavel responsavel;
}
