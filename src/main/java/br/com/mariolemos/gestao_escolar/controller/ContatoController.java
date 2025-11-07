package br.com.mariolemos.gestao_escolar.controller;

import br.com.mariolemos.gestao_escolar.model.Contato;
import br.com.mariolemos.gestao_escolar.model.dto.response.ContatoResponse;
import br.com.mariolemos.gestao_escolar.service.ContatoService;
import br.com.mariolemos.gestao_escolar.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatoResponse>> buscar(){
        List<Contato> contatos = contatoService.buscar();
        return ResponseEntity.ok().body(ContatoResponse.of(contatos));
    }


}
