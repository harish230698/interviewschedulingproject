package com.feedback.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidation(
	            MethodArgumentNotValidException ex) {

	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors()
	                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

	        return ResponseEntity.badRequest().body(errors);
	    }

	    @ExceptionHandler(FeedbackNotFoundException.class)
	    public ResponseEntity<String> handleNotFound(FeedbackNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }

}
