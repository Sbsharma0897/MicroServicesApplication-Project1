package com.RatingService.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)
	{
		ErrorDetails exDetails= ErrorDetails.builder().message(ex.getMessage()).timeStamp(LocalDateTime.now()).description(ex.getBindingResult().getFieldError().getDefaultMessage()).build();
		
	    return new ResponseEntity<ErrorDetails>(exDetails,HttpStatus.BAD_REQUEST);
				
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> duplicateBusNumberExceptionHandler(ResourceNotFoundException ex,WebRequest re)
	{
	
		ErrorDetails exDetails= ErrorDetails.builder().message(ex.getMessage()).timeStamp(LocalDateTime.now()).description(re.getDescription(false)).build();

	    return new ResponseEntity<ErrorDetails>(exDetails,HttpStatus.BAD_REQUEST);
				
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandlerHandler(Exception ex,WebRequest req)
	{
		ErrorDetails exDetails= ErrorDetails.builder().message(ex.getMessage()).timeStamp(LocalDateTime.now()).description(req.getDescription(false)).build();
	    
	    return new ResponseEntity<ErrorDetails>(exDetails,HttpStatus.BAD_REQUEST);
				
	}

}
