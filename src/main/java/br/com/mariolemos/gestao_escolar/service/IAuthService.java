package br.com.mariolemos.gestao_escolar.service;

import com.digidata.escolar_geolocation.controller.dto.request.LoginRequest;
import com.digidata.escolar_geolocation.controller.dto.response.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest request);
}
