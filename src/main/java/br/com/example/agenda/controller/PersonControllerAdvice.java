package br.com.example.agenda.controller;

import br.com.example.agenda.exception.PersonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PersonControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonException.class)
    public ResponseEntity<Object> capturaErroNull() {
        Map<String,Object> body = new HashMap<>();
        body.put("message","Dados incompletos");
        return ResponseEntity.badRequest().body(body);
    }
}
