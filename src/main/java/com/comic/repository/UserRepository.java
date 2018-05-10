package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
	User findByEmail(String email);
}
