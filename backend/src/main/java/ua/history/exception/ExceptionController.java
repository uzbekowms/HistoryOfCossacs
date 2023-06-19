package ua.history.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({EntityNotFoundException.class, FileNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = e.getFieldErrors();

        for (FieldError error : fieldErrors) {
            errors.add(error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<List<String>> handleUserAlreadyExists(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(e.getMessage()));
    }
}
