package com.example.demo.response.entity;

import java.util.ArrayList;
import java.util.List;

public class Response {
	
	private int code = 0;
	private String message = "OK";
	private List<Error> errors = new ArrayList<Error>();
	private Object payload;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Error> getErrors() {
		return errors;
	}
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
