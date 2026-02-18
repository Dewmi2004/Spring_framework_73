package lk.ijse.back_end.exception;

import lk.ijse.back_end.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIResponse<String>> handleException(Exception e) {
        return new ResponseEntity<>(new APIResponse<>( HttpStatus.BAD_REQUEST.value(),"Null Values are not Allowed",e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Map<String, String>>>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(
                new APIResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Validation Failed",
                        errors
                ),
                HttpStatus.BAD_REQUEST
        );
    }

}
