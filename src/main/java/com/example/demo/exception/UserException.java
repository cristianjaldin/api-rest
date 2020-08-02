package com.example.demo.exception;

public class UserException extends Exception {

	private static final long serialVersionUID = -1836852293863259368L;
	
	protected int code;
	protected String userMessage;
	protected String systemMessage;

	public UserException(int code, String userMessage, String systemMessage) {
		super();
		this.code = code;
		this.userMessage = userMessage;
		this.systemMessage = systemMessage;
	}
	
	public int getCode() {
		return code;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public String getSystemMessage() {
		return systemMessage;
	}
	
}