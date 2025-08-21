package com.social_media.app_project.exception;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final @Nullable ResponseEntity<Object> handleALLException(Exception ex, WebRequest request){
		ErrorDetails errordetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public final  ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request){
		ErrorDetails errordetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(errordetails,HttpStatus.NOT_FOUND);
	}
	
	protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
		ErrorDetails errordetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(errordetails,HttpStatus.BAD_REQUEST);
	}
}
