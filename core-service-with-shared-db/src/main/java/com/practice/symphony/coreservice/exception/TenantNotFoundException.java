package com.practice.symphony.coreservice.exception;

public class TenantNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TenantNotFoundException(String message) {
		super(message);
	}

}
