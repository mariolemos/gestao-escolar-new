package br.com.mariolemos.gestao_escolar.controller;

import br.com.mariolemos.gestao_escolar.model.Colegio;
import br.com.mariolemos.gestao_escolar.model.dto.request.ColegioRequest;
import br.com.mariolemos.gestao_escolar.model.dto.response.ColegioResponse;
import br.com.mariolemos.gestao_escolar.service.ColegioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/colegio")
public class ColegioController {

    @Autowired
    private ColegioService colegioService;

    @GetMapping
    public ResponseEntity<List<ColegioResponse>> buscar(){
        List<Colegio> colegios = colegioService.buscar();
        return ResponseEntity.ok().body(ColegioResponse.of(colegios));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ColegioResponse> buscarPorID(@PathVariable("id") Long id){
        Colegio colegio = colegioService.buscarPorId(id);
        return ResponseEntity.ok().body(new ColegioResponse(colegio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColegioResponse> atualizar(@RequestBody ColegioRequest colegioRequest, @PathVariable("id") Long id){
        Colegio colegio = colegioService.atualizar(ColegioRequest.of(colegioRequest), id);
        return ResponseEntity.ok().body(new ColegioResponse(colegio));
    }

    @PostMapping
    public ResponseEntity<ColegioResponse> incluir(@RequestBody @Valid ColegioRequest colegioRequest){
        Colegio colegio = colegioService.incluir(ColegioRequest.of(colegioRequest));
        return ResponseEntity.ok().body(new ColegioResponse(colegio));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        colegioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
