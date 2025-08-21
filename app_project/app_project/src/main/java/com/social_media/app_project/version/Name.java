package com.social_media.app_project.version;

public class Name {
	private String firstName;
	private String lastname;
	public String getFirstName() {
		return firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public Name(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastname=" + lastname + "]";
	}
	
}
