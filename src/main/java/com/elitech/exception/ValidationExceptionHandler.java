package com.elitech.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex)
{
	Map<String,String> errors=new HashMap<String, String>();
	ex.getBindingResult().getAllErrors().forEach(error->
	{
		String feildName=((FieldError) error).getField();
		String errorMessage=error.getDefaultMessage();
		errors.put(feildName, errorMessage);
	});
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	
}
@ExceptionHandler(RessourceNotFoundException.class)
public ResponseEntity<String> handleRessourceNotFoundException(RessourceNotFoundException ex)
{
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());	
}
}
