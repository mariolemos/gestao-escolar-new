package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.controller.dto.request.LoginRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest request);
}
