package com.udemy.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//GET
	//URI - /hello
	@RequestMapping(method=RequestMethod.GET, path="/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
}
