package com.demostration.explain_sts.controller;

public class Hellobean {
	private String message;

	public Hellobean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Hellobean [message=" + message + ", getMessage()=" + getMessage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
