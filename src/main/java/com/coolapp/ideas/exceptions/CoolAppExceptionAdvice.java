package com.coolapp.ideas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author psingh
 */
@RestControllerAdvice
public class CoolAppExceptionAdvice {
	@ResponseBody
	@ExceptionHandler(EmptyRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String emptyRequestHandler(EmptyRequestException e) {
		return e.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String invalidRequestHandler(InvalidRequestException e) {
		return e.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(EmptyFieldException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String emptyFieldRequestHandler(EmptyFieldException e) {
		return e.getMessage();
	}
}
