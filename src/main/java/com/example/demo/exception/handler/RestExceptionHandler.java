package com.example.demo.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.response.component.ResponseComponent;
import com.example.demo.response.entity.Response;

@ControllerAdvice
public class RestExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@Autowired
	private ResponseComponent responseComponent;
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Response userNotFoundException(UserNotFoundException ex) {
		logger.error("Custom Exception Code: "+ex.getCode()+" Custom Exception: "+ex.getSystemMessage(),ex);
		this.responseComponent.loadError(ex.getCode(), ex.getUserMessage(), ex.getUserMessage());
		return this.responseComponent.getOutput();
	}

}