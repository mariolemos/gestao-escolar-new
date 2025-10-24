package br.com.mariolemos.gestao_escolar.model.dto.request;


import br.com.mariolemos.gestao_escolar.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    private Long id;
    @NotBlank(message = "Logradoro obrigatório ")
    private String logradouro;
    private String numero;
    private String complemento;
    @NotBlank(message = "Bairro obrigatório")
    private String bairro;
    @NotBlank(message = "Cep brigatório")
    private String cep;
    @NotBlank(message = "Cidade obrigatória")
    private String cidade;
    @NotBlank(message = "Estado obrigatória")
    private String estado;

    public static Endereco of(EnderecoRequest enderecoRequest){
        Endereco endereco = new Endereco();

        endereco.setId(enderecoRequest.getId());
        endereco.setLogradouro(enderecoRequest.getLogradouro());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setComplemento(enderecoRequest.getComplemento());
        endereco.setBairro(enderecoRequest.getBairro());
        endereco.setCep(enderecoRequest.getCep());
        endereco.setCidade(enderecoRequest.getCidade());
        endereco.setEstado(enderecoRequest.getEstado());

        return endereco;
    }

    public static List<Endereco> of(List<EnderecoRequest> enderecosRequest){
        return enderecosRequest.stream().map(EnderecoRequest::of).collect(Collectors.toList());
    }
}
