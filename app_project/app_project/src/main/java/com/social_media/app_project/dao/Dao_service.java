package com.social_media.app_project.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.social_media.app_project.user.User;

@Component
public class Dao_service {
	private static int usercount = 0;
	private static List <User> user = new ArrayList<>();
	
	static {
		user.add(new User(++usercount,"Ravi",LocalDate.now().minusYears(30)));
		user.add(new User(++usercount,"Prasad",LocalDate.now().minusYears(25)));
		user.add(new User(++usercount,"Ram",LocalDate.now().minusYears(27)));
	}
	
	
	public List<User> findAll(){
		return user;
	}
	
	public User findone(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); //check this 
		return user.stream().filter(predicate).findFirst().orElse(null); // read this 
		}
	public User save(User users) {
		users.setId(++usercount);
		user.add(users); // check 
		return users;
	}

	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		user.removeIf(predicate);
	}
	
	
}
