package com.digidata.escolar_geolocation.controller.dto.request;

public record LoginRequest(
        String cpf,
        String password
) {}