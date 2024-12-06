package com.noyon.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private String filedName;
  private Object filedvalue;
public ResourceNotFoundException(String resourceName, String filedName, Object filedvalue) {
	super(String.format("%s not found with %s : '%s",resourceName,filedName,filedvalue));
	this.resourceName = resourceName;
	this.filedName = filedName;
	this.filedvalue = filedvalue;
}
public String getResourceName() {
	return resourceName;
}
public void setResourceName(String resourceName) {
	this.resourceName = resourceName;
}
public String getFiledName() {
	return filedName;
}
public void setFiledName(String filedName) {
	this.filedName = filedName;
}
public Object getFiledvalue() {
	return filedvalue;
}
public void setFiledvalue(Object filedvalue) {
	this.filedvalue = filedvalue;
}
  

  
}
