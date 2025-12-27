package com.interviewSchSer.exception;

import java.time.OffsetDateTime;

import com.interviewSchSer.model.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(CandidateNotEligibleException.class)
	public ResponseEntity<ErrorResponse> CandidateNotEligibleException(
			CandidateNotEligibleException ex,HttpServletRequest request){
		
		ErrorResponse errRes = buildErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRes);
		
	}
	
	
	@ExceptionHandler(InterviewAlreadyScheduledException.class)
	public ResponseEntity<ErrorResponse> InterviewAlreadyScheduledException(
			InterviewAlreadyScheduledException ex,HttpServletRequest request){
		
		ErrorResponse errRes = buildErrorResponse(HttpStatus.CONFLICT,ex.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errRes);
		
	}
	
	@ExceptionHandler(InterviewerNotAvailableException.class)
	public ResponseEntity<ErrorResponse> InterviewerNotAvailableException(
			InterviewerNotAvailableException ex,HttpServletRequest request){
		
		ErrorResponse errRes = buildErrorResponse(HttpStatus.CONFLICT,ex.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errRes);
		
	}
	
	private ErrorResponse buildErrorResponse(
            HttpStatus status,
            String message,
            String path) {

        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(OffsetDateTime.now().toString());
        error.setStatus(status.value());
        error.setError(status.getReasonPhrase());
        error.setMessage(message);
        error.setPath(path);

        return error;
    }

}
