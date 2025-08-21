package com.social_media.app_project.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.social_media.app_project.dao.Dao_service;
import com.social_media.app_project.exception.UserNotFoundException;
import com.social_media.app_project.user.User;


import jakarta.validation.Valid;

@RestController
public class User_Resource {
	private Dao_service  service;

	public User_Resource(Dao_service service) {
		super();
		this.service = service;
	}
	
	@GetMapping("users")
	public List<User> retriveAllUser(){
		return service.findAll();
	}
	
	@GetMapping("users/{id}")
	public User retieveUser(@PathVariable int id){
		User user = service.findone(id);
		if(user == null) {
			throw new UserNotFoundException("Id not avaible : "+id);
		}
		return user;
		//return service.findone(id);
	}
	
	/*@GetMapping("users/hateos/{id}")
	public EntityModel<User> retieveUserhateos(@PathVariable int id){
		User user = service.findone(id);
		if(user == null) {
			throw new UserNotFoundException("Id not avaible : "+id);
		}
		EntityModel<User> entitymodel = EntityModel.of(user);
		WebMvcLinkBuilder link = LinkTo(methodon(this.getClass().retriveAllUser()));
				//LinkTo(method(this.getClass().));
		
		entitymodel.add(link.withRel("all-users"));
		return entitymodel;
	}*/
	
	
	
	@PostMapping("users/create")
	public User createUser(@Valid @RequestBody User user) { 
		return service.save(user);
	}
	
	@PostMapping("users")
	public ResponseEntity<User> createUsewithuri(@RequestBody User user){
		User saveduser = service.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveduser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	/*private MessageSource messagesource;
	@GetMapping("hello/world-i18n")
	public String helloworldinter() {
		Locale locale = Lacale;
				//LocaleContextHolder.getLocale();
		return  messsource.get("good.morning",null,"default",locale);
				//messagesource.getMessage("good.morning.messages",null,"default",locale);
	}*/
	
}
