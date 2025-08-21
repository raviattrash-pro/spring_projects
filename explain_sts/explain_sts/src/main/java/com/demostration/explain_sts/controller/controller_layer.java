package com.demostration.explain_sts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello", method = RequestMethod.GET)
public class controller_layer {

	
	@GetMapping(path="test")
	public String hello() {
		return "hello welcome to STS ";
	}
	
	@GetMapping("/hello-world-bean")
	public Hellobean hellobean() {
		return new Hellobean("Hello bean created !!!!!!!");
	}
	
	@GetMapping("/test/{name}")
	public Hellobean pathvar(@PathVariable String name) {
		return new Hellobean("Hello !!! "+name);
	} 
}
