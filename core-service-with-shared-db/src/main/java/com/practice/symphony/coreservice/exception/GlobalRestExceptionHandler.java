package com.practice.symphony.coreservice.exception;

import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.symphony.coreservice.helper.ExceptionResponseJson;

@ControllerAdvice
public class GlobalRestExceptionHandler {

	SimpleDateFormat sdf = new SimpleDateFormat();

	@ExceptionHandler
	public ResponseEntity<ExceptionResponseJson> handleException(TenantNotFoundException exc) {

		ExceptionResponseJson response = new ExceptionResponseJson(HttpStatus.NOT_ACCEPTABLE.value(), exc.getMessage(),
				"TenantNotFoundException",String.valueOf(sdf.format(System.currentTimeMillis())));
		
		return new ResponseEntity<ExceptionResponseJson>(response,HttpStatus.NOT_ACCEPTABLE);

	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponseJson> handleException(Exception exc) {

		ExceptionResponseJson response = new ExceptionResponseJson(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				"exception..",String.valueOf(sdf.format(System.currentTimeMillis())));
		
		return new ResponseEntity<ExceptionResponseJson>(response,HttpStatus.BAD_REQUEST);

	}
	
	

}
