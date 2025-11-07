package br.com.mariolemos.gestao_escolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @JoinColumn(name = "ENDERECO_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "PESSOA_ID")
    private List<Contato> contatos = new ArrayList<Contato>();

}
