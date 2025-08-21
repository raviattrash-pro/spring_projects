package com.example.microservices.currency_exchange_service.controller;



import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currency_exchange_service.bean.CurrencyExchange;
import com.example.microservices.currency_exchange_service.repository.CurrencyExchangeRepository;

@RestController
public class Currency_Exchange_Controller {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	
	@GetMapping("/currency-exchange/from/{first_currency}/to/{second_currency}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String first_currency
			,@PathVariable String second_currency) {
		CurrencyExchange currencyExchange = new CurrencyExchange(1000L,first_currency,second_currency,BigDecimal.valueOf(85));
		 String port = environment.getProperty("local.server.port");
	        currencyExchange.setEnvironment(port);//read this error occur while doing
	        return currencyExchange;
	}
	@GetMapping("/db/currency-exchange/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValuefromdb(@PathVariable String from
			,@PathVariable String to) {
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for "+"first_currency"+from+"second_currency : "+to);
		}
	        return currencyExchange;
	}

}
