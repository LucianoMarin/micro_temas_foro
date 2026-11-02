package com.microservicio.temasforo.Exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice 
public class GlobalException {

    @ExceptionHandler (NoHandlerFoundException.class)
    public ResponseEntity<String> handle404(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ruta no encontrada");
    }

    @ExceptionHandler(java.util.NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(java.util.NoSuchElementException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("ID NO VALIDO");
    }

    @ExceptionHandler(PublicacionNotFoundException.class)
    public ResponseEntity<String> errorNoEncontrado(PublicacionNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());

    }

    @ExceptionHandler(PublicacionAlreadyExistException.class)
    public ResponseEntity<String> handleUsuarioAlreadyExist(PublicacionAlreadyExistException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());

    }




 @ExceptionHandler(ComentarioNotFoundException.class)
    public ResponseEntity<String> errorNoEncontrado(ComentarioNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());

    }

    @ExceptionHandler(ComentarioAlreadyExistException.class)
    public ResponseEntity<String> handleUsuarioAlreadyExist(ComentarioAlreadyExistException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());

    }



    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(
            org.springframework.dao.DataIntegrityViolationException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.CONFLICT.value()); // 409
        body.put("error", HttpStatus.CONFLICT.getReasonPhrase());
        body.put("message", "Error de duplicidad: se encuentra registrado.");

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);
    }
}