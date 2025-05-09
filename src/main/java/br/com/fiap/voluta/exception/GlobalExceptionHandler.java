package br.com.fiap.voluta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<?> handleNaoEncontrado(NaoEncontradoException ex) {
        return construirResposta(HttpStatus.NOT_FOUND, "Recurso não encontrado", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExcecaoGenerica(Exception ex) {
        return construirResposta(HttpStatus.INTERNAL_SERVER_ERROR, "Erro inesperado", ex.getMessage());
    }

    private ResponseEntity<Map<String, Object>> construirResposta(HttpStatus status, String error, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("Status", status.value());
        body.put("Erro", error);
        body.put("Mensagem", message);

        return ResponseEntity.status(status).body(body);
    }
}
