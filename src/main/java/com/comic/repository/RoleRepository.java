package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByName(String name);
}
