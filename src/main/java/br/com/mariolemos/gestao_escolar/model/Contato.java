package br.com.mariolemos.gestao_escolar.model;

import br.com.mariolemos.gestao_escolar.enumerations.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private Long id;
    @Column(name = "CONTATO")
    private String contato;
    @Column(name = "TIPO_CONTATO")
    @Enumerated(EnumType.STRING)
    private TipoContato tipo;
    @ManyToOne()
    @JoinColumn(name = "COLEGIO_ID")
    private Colegio colegio;
}
