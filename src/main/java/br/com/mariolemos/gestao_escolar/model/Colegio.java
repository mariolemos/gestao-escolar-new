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
    private String horario;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLEGIO_ID")
    private List<Contato> contatos = new ArrayList<Contato>();
    @OneToOne(mappedBy = "colegio", cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToMany
    @JoinColumn(name = "COLEGIO_ID")
    private List<Aluno> alunos = new ArrayList<>();
    @PrePersist
    private void prePersist(){
        this.endereco.setColegio(this);
        this.contatos.forEach(contato -> contato.setColegio(this));
    }

}
