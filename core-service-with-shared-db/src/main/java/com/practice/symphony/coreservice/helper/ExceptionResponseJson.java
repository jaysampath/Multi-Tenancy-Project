package com.practice.symphony.coreservice.helper;

public class ExceptionResponseJson {
	
	public int status;
	
	public String message;
	
	public String exceptionName;
	
	public String timeStamp;

	public ExceptionResponseJson(int status, String message,String exceptionName, String timeStamp) {
		this.status = status;
		this.message = message;
		this.exceptionName=exceptionName;
		this.timeStamp = timeStamp;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
	

}
