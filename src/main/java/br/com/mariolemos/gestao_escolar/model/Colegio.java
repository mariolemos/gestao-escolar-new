package br.com.mariolemos.gestao_escolar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COLEGIO")
public class Colegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "HORARIO")
    private LocalTime horario;
//    @OneToMany
//    @JsonIgnore
//    @JoinColumn(name = "COLEGIO_ID")
//    private List<Aluno> alunos = new ArrayList<Aluno>();
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "COLEGIO_ID")
//    private List<Contato> contatos = new ArrayList<Contato>();
//    @OneToOne(mappedBy = "colegio")
//    private Endereco endereco;

}
