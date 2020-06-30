package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;

@RestController
public class PersonController {

	@GetMapping("/person")
	public Person person() {
		Person p = new Person();
		p.setName("Cristian");
		p.setSurname("Jaldin");
		return p;
	}

}
