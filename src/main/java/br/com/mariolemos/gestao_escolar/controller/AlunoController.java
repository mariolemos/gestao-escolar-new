package br.com.mariolemos.gestao_escolar.controller;

import br.com.mariolemos.gestao_escolar.model.Aluno;
import br.com.mariolemos.gestao_escolar.model.dto.request.AlunoRequest;
import br.com.mariolemos.gestao_escolar.model.dto.response.AlunoResponse;
import br.com.mariolemos.gestao_escolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> buscar() {
        List<Aluno>  alunos = alunoService.buscar();
        return ResponseEntity.ok().body(AlunoResponse.of(alunos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> buscarPorId(@PathVariable("id") Long id) {
        Aluno  aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok().body(new AlunoResponse(aluno));
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> inserir(@RequestBody AlunoRequest alunoRequest ){
        Aluno aluno =  alunoService.incluir(AlunoRequest.Of(alunoRequest));
        return ResponseEntity.ok().body(new AlunoResponse(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable("id") Long id, @RequestBody AlunoRequest alunoRequest ){
        Aluno aluno = alunoService.atualizar(AlunoRequest.Of(alunoRequest), id);
        return ResponseEntity.ok().body(new AlunoResponse(aluno));
    }
}
