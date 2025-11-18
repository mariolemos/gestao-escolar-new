package br.com.mariolemos.gestao_escolar.controller;

import br.com.mariolemos.gestao_escolar.model.Responsavel;
import br.com.mariolemos.gestao_escolar.model.dto.request.ResponsavelRequest;
import br.com.mariolemos.gestao_escolar.model.dto.response.ResponsavelResponse;
import br.com.mariolemos.gestao_escolar.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity<List<ResponsavelResponse>> buscar() {
        List<Responsavel> responsaveis = responsavelService.buscar();
        return ResponseEntity.ok().body(ResponsavelResponse.of(responsaveis));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelResponse> buscarPorId(@PathVariable Long id) {
        Responsavel responsavel = responsavelService.buscarPorId(id);
        return ResponseEntity.ok().body(new ResponsavelResponse(responsavel));
    }

    @PostMapping
    public ResponseEntity<ResponsavelResponse> incluir (@RequestBody ResponsavelRequest responsavelRequest) {
        Responsavel responsavel = responsavelService.incluir(ResponsavelRequest.of(responsavelRequest));
        return ResponseEntity.ok().body(new ResponsavelResponse(responsavel));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponsavelResponse> atualizar (@RequestBody ResponsavelRequest responsavelRequest, @PathVariable("id") Long id) {
        Responsavel responsavel = responsavelService.alterar(ResponsavelRequest.of(responsavelRequest), id);
        return ResponseEntity.ok().body(new ResponsavelResponse(responsavel));
    }

}
