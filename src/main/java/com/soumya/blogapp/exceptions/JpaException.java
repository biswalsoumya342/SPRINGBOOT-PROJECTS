package com.soumya.blogapp.exceptions;

public class JpaException extends RuntimeException {
	
	private String resource;
	
	private String operation;
	
	public JpaException(String resource,String operation) {
		super(String.format("%s %s Unsuccessful!",resource,operation));
		this.resource = resource;
		this.operation = operation;
		
	}
	
	
}
