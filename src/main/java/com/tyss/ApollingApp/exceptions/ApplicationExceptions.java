package com.tyss.ApollingApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.ApollingApp.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptions {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userNotFoundExceptionHandler(UserNotFoundException u) {
		ResponseStructure<String> response = new ResponseStructure<>() ;
		response.setStatuscode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Request Failed");
		response.setData(u.getMessage());
		return new ResponseEntity(response,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(value = PresentationNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> presentationNotFoundExceptionHandler(PresentationNotFoundException u) {
		ResponseStructure<String> response = new ResponseStructure<>() ;
		response.setStatuscode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Request Failed");
		response.setData(u.getMessage());
		return new ResponseEntity(response,HttpStatus.NOT_FOUND) ;
	}
}
