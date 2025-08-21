package com.example.microservices.currency_conversion_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservices.currency_conversion_service.bean.CurrenctConversion;

@FeignClient(name = "currency-exchange", url = "http://localhost:8001")
//@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/db/currency-exchange/{from}/to/{to}")
    CurrenctConversion retrieveExchangeValuefromdb(
        @PathVariable String from,
        @PathVariable String to);
}