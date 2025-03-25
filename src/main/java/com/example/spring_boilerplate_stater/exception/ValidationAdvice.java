package com.example.spring_boilerplate_stater.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ValidationAdvice {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ValidationErrorResponse> handleMethodArgumenetNotValidException(MethodArgumentNotValidException exception){
        final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		final List<String> errorList = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

		final ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(HttpStatus.BAD_REQUEST, LocalDateTime.now(), errorList);

		log.warn("Validation errors : {} , Parameters : {}", errorList, exception.getBindingResult().getTarget());

		return ResponseEntity.status(validationErrorResponse.getStatus()).body(validationErrorResponse);
    }
}
