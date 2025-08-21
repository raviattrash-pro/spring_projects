package com.example.microservices.currency_conversion_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.currency_conversion_service.bean.CurrenctConversion;
import com.example.microservices.currency_conversion_service.feign.CurrencyExchangeProxy;

@RestController
public class Currency_controller {
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenctConversion  calculateCurrencyconversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {	
		
		return new CurrenctConversion(1000L,from,to,quantity,BigDecimal.ONE,BigDecimal.ONE,"7000");
		
	}
	@GetMapping("/call-exchange/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenctConversion  calculateCurrencyconversionwithexchangeservice(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		HashMap<String, String> urivariable = new HashMap<>();
		urivariable.put("from",from);
		urivariable.put("to",to);
		ResponseEntity<CurrenctConversion> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8001/db/currency-exchange/{from}/to/{to}",CurrenctConversion.class,urivariable);
		CurrenctConversion currencyconversion = responseEntity.getBody();
		return new CurrenctConversion(currencyconversion.getId(),from,to,quantity,currencyconversion.getConversionMultiple(),quantity.multiply(currencyconversion.getConversionMultiple()),currencyconversion.getEnvironment()+"normal call ");
		
	}
	

	
	@GetMapping("/call-exchange-feign/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenctConversion  calculateCurrencyconversionwithexchangeservicefeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrenctConversion currencyconversion = proxy.retrieveExchangeValuefromdb(from,to);
		
		return new CurrenctConversion(currencyconversion.getId(),from,to,quantity,currencyconversion.getConversionMultiple(),quantity.multiply(currencyconversion.getConversionMultiple()),currencyconversion.getEnvironment()+" "+"feign service ");
		
	}

}
