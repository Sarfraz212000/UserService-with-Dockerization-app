package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleUserNotFoundEx(UserNotFoundException ex) {

		ApiErrorResponse response = new ApiErrorResponse(ex.getMessage(), false, LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorResponse> handleGlobalException(Exception ex) {

		ApiErrorResponse response = new ApiErrorResponse("Internal ServerError: " + ex.getMessage(), false,
				LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
