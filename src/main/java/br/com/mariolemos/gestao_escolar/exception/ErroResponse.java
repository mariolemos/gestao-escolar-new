package br.com.mariolemos.gestao_escolar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {
    private List<String> mensagens = new ArrayList<>();
    private String mensagem;
    private int status;

    public void setMensagens(Map<String, String> mensagens) {
        mensagens.forEach((key, value) -> this.mensagens.add(key + ": " + value));
    }
}
