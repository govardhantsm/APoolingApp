package com.tyss.ApollingApp.exceptions;

public class RatingNotFoundException extends RuntimeException {
	private String message;

	public RatingNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

} 


