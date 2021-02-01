package com.geometria.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.geometria.dto.error.ErrorDto;
import com.geometria.exceptions.BadRequestException;
import com.geometria.exceptions.NoContentException;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus statusm, WebRequest request){
		
		ErrorDto response = new ErrorDto();
		response.setMensaje(e.getLocalizedMessage());
		response.setExceptionType(e.getClass().getSimpleName());
		
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({NoContentException.class})
	@ResponseBody
	public ResponseEntity<ErrorDto> handleNoContentException(Exception e){
		NoContentException exception = (NoContentException) e;
		ErrorDto response = new ErrorDto();
		
		response.setMensaje(exception.getLocalizedMessage());;
		response.setExceptionType(exception.getClass().getSimpleName());
		
		return new ResponseEntity<ErrorDto>(response, HttpStatus.NO_CONTENT);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({BadRequestException.class})
	@ResponseBody
	public ResponseEntity<ErrorDto> handleBadRequestException(Exception e){
		BadRequestException exception = (BadRequestException) e;
		ErrorDto response = new ErrorDto();
		
		response.setMensaje(exception.getLocalizedMessage());;
		response.setExceptionType(exception.getClass().getSimpleName());
		
		return new ResponseEntity<ErrorDto>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	@ResponseBody
	public ResponseEntity<ErrorDto> handleException(Exception e){
		ErrorDto response = new ErrorDto();
		
		response.setMensaje(e.getLocalizedMessage());;
		response.setExceptionType(e.getClass().getSimpleName());
		
		return new ResponseEntity<ErrorDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
