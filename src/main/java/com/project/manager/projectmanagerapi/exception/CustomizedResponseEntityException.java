package com.project.manager.projectmanagerapi.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController // this will provide resp in case of exp
public class CustomizedResponseEntityException 
extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class) //giving whaterver exp we want to handle
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(expResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class) //giving whaterver exp we want to handle
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(expResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProjectNotFoundException.class) //giving whaterver exp we want to handle
	public final ResponseEntity<Object> handleProjectNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(expResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AlreadyExistException.class) //giving whaterver exp we want to handle
	public final ResponseEntity<Object> handleAlreadyExistException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(expResponse, HttpStatus.BAD_REQUEST);
	}


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse expResponse = new ExceptionResponse(new Date(), 
				"Validation Error",
				ex.getBindingResult().getFieldError().toString());//  last args has info about what went wrong
		return new ResponseEntity(expResponse, HttpStatus.BAD_REQUEST);  
		
	}
	
	
}
