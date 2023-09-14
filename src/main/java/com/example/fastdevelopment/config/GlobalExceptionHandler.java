package com.example.fastdevelopment.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgument(ConstraintViolationException exception) {
        var errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation error. Check 'errors' field for details.");
        for (ConstraintViolation<?> error : exception.getConstraintViolations()) {
            errorResponse.addValidationError(error.getPropertyPath().toString(), error.getMessage());
        }
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class ErrorResponse {
        private final int status;
        private final String message;
        private String stackTrace;
        private List<ValidationError> errors;

        @Getter
        @Setter
        @RequiredArgsConstructor
        private static class ValidationError {
            private final String field;
            private final String message;
        }

        public void addValidationError(String field, String message){
            if(Objects.isNull(errors)){
                errors = new ArrayList<>();
            }
            errors.add(new ValidationError(field, message));
        }
    }
}
