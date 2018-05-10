package com.comic.service;

import java.util.List;

import com.comic.entity.Comic;

public interface ComicService {
	List<Comic> findAll ();
	
	Comic findOne(Long id);
	
	Comic save(Comic comic);
	
	void remove(Comic comic);

	
	List<Comic> findByTitle(String title);
}
