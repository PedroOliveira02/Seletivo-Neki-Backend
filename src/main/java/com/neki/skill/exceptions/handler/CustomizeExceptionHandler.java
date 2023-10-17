package com.neki.skill.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.neki.skill.common.ConversorDataHora;
import com.neki.skill.exceptions.ExceptionResponse;
import com.neki.skill.exceptions.ResourceBadRequestException;
import com.neki.skill.exceptions.ResourceNotFoundException;
import com.neki.skill.exceptions.UnauthorizedException;

@ControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			Exception ex, WebRequest request) {

			String dataHora = ConversorDataHora.converterDateParaDataHora(new Date());
		
			ExceptionResponse exceptionResponse = new ExceptionResponse(
				dataHora,
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
			Exception ex, WebRequest request) {

			String dataHora = ConversorDataHora.converterDateParaDataHora(new Date());
		
			ExceptionResponse exceptionResponse = new ExceptionResponse(
				dataHora,
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request) {

			String dataHora = ConversorDataHora.converterDateParaDataHora(new Date());
		
			ExceptionResponse exceptionResponse = new ExceptionResponse(
				dataHora,
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public final ResponseEntity<ExceptionResponse> handleUnauthorizedExceptions(
			Exception ex, WebRequest request) {

			String dataHora = ConversorDataHora.converterDateParaDataHora(new Date());
		
			ExceptionResponse exceptionResponse = new ExceptionResponse(
				dataHora,
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
	}
}
