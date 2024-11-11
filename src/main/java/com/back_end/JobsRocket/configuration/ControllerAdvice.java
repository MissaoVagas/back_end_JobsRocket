package com.back_end.JobsRocket.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.back_end.JobsRocket.exceptions.DefaultExceptionResponse;
import com.back_end.JobsRocket.exceptions.PasswordValidationError;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<DefaultExceptionResponse> handleNotFoundExceptionHandler(EntityNotFoundException entityNotFoundException){

        HttpStatus notFound = HttpStatus.NOT_FOUND;
        DefaultExceptionResponse defaultResponse = new DefaultExceptionResponse();
        defaultResponse.setStatusResponse(notFound.value());
        defaultResponse.setMessage(entityNotFoundException.getMessage());
        return new ResponseEntity<>(defaultResponse, notFound);
    }
	
	@ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<DefaultExceptionResponse> handleIllegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException){

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        DefaultExceptionResponse defaultResponse = new DefaultExceptionResponse();
        defaultResponse.setStatusResponse(badRequest.value());
        defaultResponse.setMessage(illegalArgumentException.getMessage());
        return new ResponseEntity<>(defaultResponse, badRequest);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordValidationError.class)
    public String handlerUserNewException(PasswordValidationError exception){
        return exception.getMessage();
    }

}
