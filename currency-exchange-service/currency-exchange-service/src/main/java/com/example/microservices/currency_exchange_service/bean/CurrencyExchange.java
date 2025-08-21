package com.example.microservices.currency_exchange_service.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {
	
	@Id
	private long id;
	@Column(name = "first_currency")
	private String from;
	@Column(name = "second_currency")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
	
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_currency() {
		return from;
	}
	public void setFirst_currency(String first_currency) {
		this.from = first_currency;
	}
	public String getSecond_currency() {
		return to;
	}
	public void setSecond_currency(String second_currency) {
		this.to = second_currency;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to="
				+ to + ", conversionMultiple=" + conversionMultiple + "]";
	}
	public CurrencyExchange(long id, String first_currency, String second_currency, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = first_currency;
		this.to = second_currency;
		this.conversionMultiple = conversionMultiple;
	}
	public CurrencyExchange() {}
	
	

}
