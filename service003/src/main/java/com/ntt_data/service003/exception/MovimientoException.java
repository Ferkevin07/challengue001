package com.ntt_data.service003.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

public class MovimientoException extends RuntimeException {
    public MovimientoException(String mensaje) {
        super(mensaje);
    }
}


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MovimientoException.class)
    public ResponseEntity<Map<String, Object>> manejarMovimientoException(MovimientoException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("error", "Movimiento no válido");
        error.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
