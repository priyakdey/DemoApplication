package com.example.demo.execption.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.execption.StudentNotFoundException;
import com.example.demo.execption.response.ErrorResponse;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {StudentNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException e, WebRequest web) {
		ErrorResponse response = new ErrorResponse(e.getMessage(), new Date());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ErrorResponse> handleGenericException(Exception e, WebRequest web) {
		String message = e.getMessage() == null ? e.getLocalizedMessage() : e.getMessage();
		ErrorResponse response = new ErrorResponse(message, new Date());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
