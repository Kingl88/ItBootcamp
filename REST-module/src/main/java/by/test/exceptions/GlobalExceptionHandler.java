package by.test.exceptions;

import by.test.api.exceptions.DataValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<?> catchDataValidationException(DataValidationException e) {
        return new ResponseEntity<>(e.getMessages(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    private ResponseEntity<?> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
