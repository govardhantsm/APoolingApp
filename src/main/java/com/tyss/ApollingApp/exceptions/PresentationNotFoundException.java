package com.tyss.ApollingApp.exceptions;

public class PresentationNotFoundException extends RuntimeException {
    String message ;
    public PresentationNotFoundException(String message) {
    	this.message = message ;
    }
    
    @Override
    public String getMessage() {
    	
    	return message ;
    }
}
