package ua.axellos.kanbanrider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProjectNameIsUsedException extends RuntimeException {

    public ProjectNameIsUsedException() {
        super();
    }

    public ProjectNameIsUsedException(String message) {
        super(message);
    }
}
