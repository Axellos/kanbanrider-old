package ua.axellos.kanbanrider.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.axellos.kanbanrider.exception.ProjectNameIsUsedException;

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

        return validationFailedResponse(responseBody);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleProjectNameTakenException(ProjectNameIsUsedException exception) {
        return validationFailedResponse(Map.ofEntries(Map.entry("email", exception.getMessage())));
    }

    private ResponseEntity<?> validationFailedResponse(Map<String, String> body) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .header("X-Status-Reason", "Validation failed")
                .body(body);
    }
}
