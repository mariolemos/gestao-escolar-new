package br.com.mariolemos.gestao_escolar.controller;

import br.com.mariolemos.gestao_escolar.model.Contrato;
import br.com.mariolemos.gestao_escolar.model.dto.request.ContratoRequest;
import br.com.mariolemos.gestao_escolar.model.dto.response.ContratoResponse;
import br.com.mariolemos.gestao_escolar.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contrato")
public class ContratoController {

    @Autowired
    ContratoService contratoService;

    @GetMapping
    public ResponseEntity<List<ContratoResponse>> buscar(){
        List<Contrato> contratos = contratoService.buscar();
        return ResponseEntity.ok().body(ContratoResponse.of(contratos));
    }

    @PostMapping
    public ResponseEntity<ContratoResponse> incluir(@RequestBody ContratoRequest contratoRequest) {
        Contrato contrato = contratoService.incluir(ContratoRequest.of(contratoRequest));
        return ResponseEntity.ok().body(new ContratoResponse(contrato));
    }
}
