package com.comic;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.comic.entity.User;
import com.comic.security.Role;
import com.comic.security.UserRole;
import com.comic.service.UserService;
import com.comic.utility.SecurityUtility;

@SpringBootApplication
public class ComicApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ComicApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("asd");
		user1.setLastName("asd");
		user1.setUsername("asd");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("asd"));
		user1.setEmail("asd@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		Role role2= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		role2.setRoleId(2);
		role2.setName("ROLE_MANAGER");
		userRoles.add(new UserRole(user1, role1));
		userRoles.add(new UserRole(user1, role2));
		userService.createUser(user1, userRoles);
		
		
		User user2 = new User();
		user2.setFirstName("qwe");
		user2.setLastName("qwe");
		user2.setUsername("qwe");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("qwe"));
		user2.setEmail("qwe@gmail.com");
		Set<UserRole> userRoles2 = new HashSet<>();
		userRoles2.add(new UserRole(user2, role1));
		
		userService.createUser(user2, userRoles2);
	}
}
