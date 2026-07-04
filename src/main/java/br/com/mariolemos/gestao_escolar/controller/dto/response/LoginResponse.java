package com.digidata.escolar_geolocation.controller.dto.response;

public record LoginResponse(
        String token,
        String expiresInToken,
        String nome,
        String username
) {}