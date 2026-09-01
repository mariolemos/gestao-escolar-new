package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.model.User;

public interface IJwtService {

    String generateToken(User user);
    String extractUsername(String token);
}
