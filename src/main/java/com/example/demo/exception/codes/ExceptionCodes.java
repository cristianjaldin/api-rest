package com.example.demo.exception.codes;

public enum ExceptionCodes {
	
	USER_NOT_FOUND(1,"User not found.","User not found.");
	
	private int code;
	private String userMessage;
	private String systemMessage;
	
	private ExceptionCodes(int code, String userMessage, String systemMessage) {
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
