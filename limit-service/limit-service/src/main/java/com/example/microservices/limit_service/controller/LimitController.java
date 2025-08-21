package com.example.microservices.limit_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limit_service.bean.Limit;
import com.example.microservices.limit_service.configuration.My_Configuration;

@RestController
public class LimitController {
	@Autowired
	private My_Configuration myconfiguration;
	
	@GetMapping("/limits")
	public Limit retrivelimits() {
		return new Limit(myconfiguration.getMinimum(),myconfiguration.getMaximum());
	}

}
