package com.example.demo.exception;

import java.time.LocalDateTime;

public class ApiErrorResponse {
	
	private String message;
	
	private boolean success;
	
	private LocalDateTime timestamp;
	
	private int status;
	
	

	public ApiErrorResponse(String message, boolean success, LocalDateTime timestamp, int status) {
		super();
		this.message = message;
		this.success = success;
		this.timestamp = timestamp;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
