package br.com.mariolemos.gestao_escolar.model;

import br.com.mariolemos.gestao_escolar.model.dto.response.ResponsavelResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "PARENTESCO")
    private String parentesco;
    @OneToMany
    @JoinColumn(name = "RESPONSAVEL_ID")
    private List<Aluno> alunos = new ArrayList<>();

    private void prePesist(){
        this.getEndereco().setPessoa(this);
    }

}


