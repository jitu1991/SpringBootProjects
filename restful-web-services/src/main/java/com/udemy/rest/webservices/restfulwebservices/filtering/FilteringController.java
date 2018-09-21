package com.udemy.rest.webservices.restfulwebservices.filtering;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public TestBean retrieveBean() {
		return new TestBean("value1", "value2", "value3");
	}
	
}
