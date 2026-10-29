package br.com.mariolemos.gestao_escolar.controller;

import br.com.mariolemos.gestao_escolar.controller.dto.request.MensalidadeRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.MensalidadeResponse;
import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import br.com.mariolemos.gestao_escolar.service.MensalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mensalidades")
public class MensalidadeController {

    @Autowired
    private MensalidadeService mensalidadeService;

//    @PostMapping
//    public ResponseEntity<MensalidadeResponse> incluir(@RequestBody MensalidadeRequest mensalidadeRequest) {
//        Mensalidade mensalidade = mensalidadeService.incluir(MensalidadeRequest.Of(mensalidadeRequest), mensalidadeRequest.getContratoId());
//        return ResponseEntity.ok().body(new MensalidadeResponse(mensalidade));
//    }

    @GetMapping
    public ResponseEntity<List<MensalidadeResponse>> listar(){
        List<Mensalidade> mensalidades = mensalidadeService.buscar();
        return ResponseEntity.ok().body(MensalidadeResponse.of(mensalidades));
    }

    @PutMapping("/pagarMensalidade/{id}")
    public ResponseEntity<MensalidadeResponse> pagarMensalidade(@RequestBody MensalidadeRequest mensalidadeRequest, @PathVariable("id") Long Id){
        Mensalidade mensalidade = mensalidadeService.pagarMensalidade(MensalidadeRequest.Of(mensalidadeRequest), Id);
        return ResponseEntity.ok().body(new MensalidadeResponse(mensalidade));
    }

    @GetMapping("/abonarMensalidade/{id}")
    public ResponseEntity<MensalidadeResponse> abonarMensalidade(MensalidadeRequest mensalidadeRequest, @PathVariable("id") Long Id){
        Mensalidade mensalidade = mensalidadeService.abonarMensalidade(MensalidadeRequest.Of(mensalidadeRequest), Id);
        return ResponseEntity.ok().body(new MensalidadeResponse(mensalidade));
    }

}