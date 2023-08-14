package com.coolapp.ideas.exceptions;

/**
 * @author psingh
 */
public class EmptyRequestException extends CoolAppException {
	@Override
	public String getMessage() {
		return "Request is empty";
	}
}
