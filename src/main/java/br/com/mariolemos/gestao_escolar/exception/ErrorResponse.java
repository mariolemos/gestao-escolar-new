package br.com.mariolemos.gestao_escolar.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(

        LocalDateTime timestamp,
        Integer status,
        String error,
        String message,
        String path,
        List<String> details

) {}