package br.com.mariolemos.gestao_escolar.controller.dto.request;

public record LoginRequest(
        String cpf,
        String password
) {}