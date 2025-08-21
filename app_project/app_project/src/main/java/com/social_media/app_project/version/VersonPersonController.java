package com.social_media.app_project.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersonPersonController {
	
	
	//1.url versioning - twittter
	@GetMapping("/v1/person")
	public Personv1 getfirstversionofperson() {
		return new Personv1("Ravi Prasad !!");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getsecondversionofperson() {
		return new Personv2(new Name("Ravi","Prasad"));
	}
	
	
	
	//2. Request param versioning - amazon
	@GetMapping(path="/person",params="version")
	public Personv1 getfirstversionofpersonrequestParameter() {
		return new Personv1("Ravi Prasad !!");
	}
	
	/*@GetMapping(path="/person",params="version")
	 * public Personv2 getsecondversionofpersonrequestParameter() {
		return new Personv2(new Name("Ravi","Prasad"));
	}*/
	
	
	
	//3. Custom header versioning - microsoft
	@GetMapping(path="/person/header",headers = "x-API-version=1")
	public Personv1 getfirstversionofpersonrequestHeader() {
		return new Personv1("Ravi Prasad !!");
	}
	
	@GetMapping(path="/person/header",headers = "x-API-version=2")
	public Personv2 getsecondversionofpersonrequestHeader() {
		return new Personv2(new Name("Ravi","Prasad"));
	}
	
	
	//4. media typer versioning (a.k.a "content negotiation "or "accept header")-github
	
	@GetMapping(path="/person/accept",produces = "application/vnd.companay.app-v1+json")
	public Personv1 getfirstversionofpersonrequestAcceptHeader() {
		return new Personv1("Ravi Prasad !!");
	}
	
	@GetMapping(path="/person/accept",produces = "application/vnd.companay.app-v2+json")
	public Personv2 getsecondversionofpersonrequestAcceptHeader() {
		return new Personv2(new Name("Ravi","Prasad"));
	}
}
