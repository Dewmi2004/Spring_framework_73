package lk.ijse.security_backend.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lk.ijse.security_backend.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIResponse handleUserNameNotFoundException(UsernameNotFoundException ex) {
       return new APIResponse(HttpStatus.NOT_FOUND.value(), "Username Not Found", ex.getMessage());
    }
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public APIResponse handleBadCredentialsException(BadCredentialsException ex) {
       return new APIResponse(HttpStatus.UNAUTHORIZED.value(), "Username or Password is incorrect", ex.getMessage());
    }
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public APIResponse handleExpiredJwtException(ExpiredJwtException ex) {
       return new APIResponse(HttpStatus.UNAUTHORIZED.value(), "Expired Token", ex.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIResponse handleRuntimeException(RuntimeException ex) {
       return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Occurred", ex.getMessage());
    }
}
