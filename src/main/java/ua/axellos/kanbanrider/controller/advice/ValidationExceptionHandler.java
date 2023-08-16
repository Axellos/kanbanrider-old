package ua.axellos.kanbanrider.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> responseBody = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(error -> {
            responseBody.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(responseBody);
    }
}
