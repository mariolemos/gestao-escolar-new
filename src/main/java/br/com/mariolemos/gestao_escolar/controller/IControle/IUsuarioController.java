package br.com.mariolemos.gestao_escolar.controller.IControle;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface IUsuarioController<Request, Response> {

    @PreAuthorize("hasAuthority('USUARIO:CREATE')")
    @PostMapping
    Response create(@RequestBody Request request);

    @PutMapping({"{id}"})
    Response update(@RequestBody Request request, @PathVariable UUID id);

    @PreAuthorize("hasAuthority('USUARIO:VIEW')")
    @GetMapping
    List<Response> list();

    @PreAuthorize("hasAuthority('USUARIO:VIEW')")
    @GetMapping({"{id}"})
    Response findById(@PathVariable UUID id);

    @PreAuthorize("hasAuthority('USUARIO:DELETE')")
    @DeleteMapping
    void delete(@PathVariable UUID id);
}
