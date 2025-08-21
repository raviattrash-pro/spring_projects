package com.social_media.app_project.version;

public class Personv2 {
	private Name name;

	public Personv2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Personv2 [name=" + name + "]";
	}
	
	
}
