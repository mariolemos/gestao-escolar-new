package br.com.mariolemos.gestao_escolar.controller.dto.response;

import java.util.List;
import java.util.Map;

public record LoginResponse(
        String token,
        String expiresInToken,
        String nome,
        String username,
        Map<String, List<String>> resource
) {}