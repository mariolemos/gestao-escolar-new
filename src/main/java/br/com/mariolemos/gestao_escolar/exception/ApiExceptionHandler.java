package br.com.mariolemos.gestao_escolar.exception;

import br.com.digidata.crud.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        ErroResponse erroResponse = new ErroResponse();
        erroResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        erroResponse.setMensagens(errors);
        return new ResponseEntity<>(erroResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErroResponse> handleException(SQLException ex) {

        ErroResponse erroResponse = new ErroResponse();
        erroResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        erroResponse.setMensagem(ex.getMessage());
        return new ResponseEntity<>(erroResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErroResponse> handleException(RegraDeNegocioException ex) {

        ErroResponse erroResponse = new ErroResponse();
        erroResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        erroResponse.setMensagem(ex.getMessage());
        return new ResponseEntity<>(erroResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request
    ){

        ErrorResponse response =
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.name(),
                        ex.getMessage(),
                        request.getRequestURI(),
                        Collections.emptyList()
                );


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }



    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusiness(
            BusinessException ex,
            HttpServletRequest request
    ){

        ErrorResponse response =
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.name(),
                        ex.getMessage(),
                        request.getRequestURI(),
                        Collections.emptyList()
                );


        return ResponseEntity
                .badRequest()
                .body(response);
    }




    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(
            UnauthorizedException ex,
            HttpServletRequest request
    ){


        ErrorResponse response =
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.UNAUTHORIZED.value(),
                        HttpStatus.UNAUTHORIZED.name(),
                        ex.getMessage(),
                        request.getRequestURI(),
                        Collections.emptyList()
                );


        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);

    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ErrorResponse> handleDeniedException(
            Exception ex,
            HttpServletRequest request
    ){


        ErrorResponse response =
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.FORBIDDEN.value(),
                        HttpStatus.FORBIDDEN.name(),
                        "Usuário não tem permissão para acessar essa funcinalidade.",
                        request.getRequestURI(),
                        Arrays.asList(ex.getMessage())
                );


        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(response);

    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(
            Exception ex,
            HttpServletRequest request
    ){


        ErrorResponse response =
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.FORBIDDEN.value(),
                        HttpStatus.FORBIDDEN.name(),
                        "Usuário não tem permissão para acessar essa funcinalidade.",
                        request.getRequestURI(),
                        Arrays.asList(ex.getMessage())
                );


        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(response);

    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(
            Exception ex,
            HttpServletRequest request
    ){


        ErrorResponse response =
                new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR.name(),
                        "Erro interno no servidor",
                        request.getRequestURI(),
                        Arrays.asList(ex.getMessage())
                );


        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);

    }
}


