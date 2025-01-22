package com.bloggingApi.blogging.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String ResourceName;
    String fieldvalue;
    long fieldName;
public ResourceNotFoundException(String resourceName, String fieldvalue, String fieldName) {
	super();
	ResourceName = resourceName;
	this.fieldvalue = fieldvalue;
	this.fieldName = fieldName;
}
   
}
