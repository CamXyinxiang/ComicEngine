package com.comic.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.Comic;
import com.comic.security.Role;

public interface ComicRepository extends CrudRepository<Comic, Long>{

	List<Comic> findAllByTitle(String title);
	
	
}
