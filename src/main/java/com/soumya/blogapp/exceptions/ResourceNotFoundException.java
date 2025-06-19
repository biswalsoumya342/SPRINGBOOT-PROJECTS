package com.soumya.blogapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	private String resource;
	
	private String fieldName;
	
	private long fieldValue;
	
	public ResourceNotFoundException(String resource,String fieldName,long fieldValue) {
		super(String.format("%s Not Found With %s:%s",resource,fieldName,fieldValue));
		this.resource = resource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
