package com.interviewSchSer.exception;

import java.time.OffsetDateTime;

import com.interviewSchSer.model.ErrorResponse;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(CandidateNotEligibleException.class)
	public ResponseEntity<ErrorResponse> CandidateNotEligibleException(
			CandidateNotEligibleException ex,HttpServletRequest request){
		
		ErrorResponse errRes = buildErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRes);
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(
            IllegalArgumentException ex,
            HttpServletRequest request) {

		ErrorResponse errRes = buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                request.getRequestURI()
        );
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errRes);
    }
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(
            DataIntegrityViolationException ex,
            HttpServletRequest request) {

		ErrorResponse errRes = buildErrorResponse(
                HttpStatus.CONFLICT,
                ex.getMessage(),
                request.getRequestURI()
        );
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errRes);
    }

	
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(
            EntityNotFoundException ex,
            HttpServletRequest request) {

		ErrorResponse errRes =  buildErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request.getRequestURI()
        );
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRes);
    }
	
	
	@ExceptionHandler(InterviewAlreadyScheduledException.class)
	public ResponseEntity<ErrorResponse> InterviewAlreadyScheduledException(
			InterviewAlreadyScheduledException ex,HttpServletRequest request){
		
		ErrorResponse errRes = buildErrorResponse(HttpStatus.CONFLICT,ex.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errRes);
		
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

		ErrorResponse errRes = buildErrorResponse(
        		HttpStatus.INTERNAL_SERVER_ERROR,
        		ex.getMessage(),
                request.getRequestURI()
        );
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errRes);
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
