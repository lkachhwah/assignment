package com.shoppingcart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shoppingcart.Exception.BusinessException;

@ControllerAdvice
public class ControllerExceptionHandler  {

	
	@ExceptionHandler({ BusinessException.class})
    public ResponseEntity<String> handleException(BusinessException exception) {
		if(BusinessException.DATA_VALIDATE_ISSUE.equalsIgnoreCase(exception.getCode()))
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		else if(BusinessException.DATA_MISSING_IN_DB.equalsIgnoreCase(exception.getCode()))
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
	
	@ExceptionHandler
    public ResponseEntity<String> handleException(Exception exception) {
				return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
