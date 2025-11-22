package br.com.mariolemos.gestao_escolar.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Contato> contatos = new ArrayList<Contato>();

    @PrePersist
    @PreUpdate
    private  void prePesist() {
        this.contatos.forEach(contato -> contato.setPessoa(this));
        if(endereco != null) {
            this.endereco.setPessoa(this);
        }

    }

}
