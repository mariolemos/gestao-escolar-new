package br.com.mariolemos.gestao_escolar.model.dto.response;

import br.com.mariolemos.gestao_escolar.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

    private Long id;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public EnderecoResponse(Endereco endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }
     public static EnderecoResponse of(Endereco endereco) {
        if(endereco == null) {
            return new EnderecoResponse();
        }
        return new EnderecoResponse(endereco);
     }
}
