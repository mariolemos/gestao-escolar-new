package br.com.mariolemos.gestao_escolar.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @NotBlank(message =  "Cpf é obrigatório")
    @CPF
    private String cpf;
    private String rg;

}
