package com.coolapp.ideas.exceptions;

import lombok.RequiredArgsConstructor;

/**
 * @author psingh
 */
@RequiredArgsConstructor
public class InvalidRequestException extends CoolAppException {
	private final String fieldName;
	@Override
	public String getMessage() {
		return fieldName + "is not valid";
	}
}
