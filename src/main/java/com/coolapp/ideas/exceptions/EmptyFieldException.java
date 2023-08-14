package com.coolapp.ideas.exceptions;

import lombok.RequiredArgsConstructor;

/**
 * @author psingh
 */
@RequiredArgsConstructor
public class EmptyFieldException extends EmptyRequestException {
	private final String fieldName;

	@Override
	public String getMessage() {
		return "expected " + fieldName + " is empty";
	}
}
