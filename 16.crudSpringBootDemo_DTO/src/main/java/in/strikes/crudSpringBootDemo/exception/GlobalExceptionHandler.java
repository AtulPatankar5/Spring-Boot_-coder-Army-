package in.strikes.crudSpringBootDemo.exception;

import in.strikes.crudSpringBootDemo.dto.ExceptionResponseDto;
import in.strikes.crudSpringBootDemo.dto.ValidationExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(ResourceNotException e, HttpServletRequest httpServletRequest) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                httpServletRequest.getRequestURI()
        );

        return ResponseEntity.
                status(HttpStatus.NOT_FOUND).
                body(exceptionResponseDto);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDto> handleDuplicateResourceException(DuplicateResourceException e, HttpServletRequest httpServletRequest) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage(),
                httpServletRequest.getRequestURI()
        );
        return ResponseEntity.
                status(HttpStatus.CONFLICT).
                body(exceptionResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e,
            HttpServletRequest httpServletRequest) {

        Map<String, String> fieldErrors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
                fieldErrors.put(error.getField(), error.getDefaultMessage()));

        ValidationExceptionResponseDto validationExceptionResponseDto = new ValidationExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Failed",
                httpServletRequest.getRequestURI(),
                fieldErrors
        );
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST).
                body(validationExceptionResponseDto);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException e, HttpServletRequest httpServletRequest) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage(),
                httpServletRequest.getRequestURI()
        );
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(exceptionResponseDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception e, HttpServletRequest httpServletRequest) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage(),
                httpServletRequest.getRequestURI()
        );
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(exceptionResponseDto);
    }
}
