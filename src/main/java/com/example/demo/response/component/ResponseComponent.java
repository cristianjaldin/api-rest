package com.example.demo.response.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.response.entity.Response;
import com.example.demo.response.entity.Error;

@RequestScope
@Component
public class ResponseComponent {
	
	private Response response = new Response();
	
	public void setPayload(Object o) {
		this.response.setPayload(o);
	}
	
	public void loadError(int code, String message, String description) {
		this.response.setCode(1);
		this.response.setMessage("");
		Error e = new Error(code,message,description);
		this.response.getErrors().add(e);
	}
	
	public Response getOutput() {
		return this.response;
	}
}
