package com.example.demo.exception;

import com.example.demo.exception.codes.ExceptionCodes;

public class UserNotFoundException extends UserException {

	private static final long serialVersionUID = -3204705332368137965L;
	private static final ExceptionCodes exceptionCode = ExceptionCodes.USER_NOT_FOUND;

	public UserNotFoundException() {
		super(exceptionCode.getCode(), exceptionCode.getUserMessage(), exceptionCode.getSystemMessage());
	}		
}