package com.comic.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.entity.Comic;
import com.comic.repository.ComicRepository;
import com.comic.service.ComicService;

@Service
public class ComicServiceImpl implements ComicService{
	@Autowired
	private ComicRepository comicRepository;
	
	public Comic save(Comic comic) {
		return comicRepository.save(comic);
	}
	
	public List<Comic> findAll() {
		return (List<Comic>) comicRepository.findAll();
	}
	
	public Comic findOne(Long id) {
		return comicRepository.findOne(id);
	}
	
	public List<Comic> findByTitle(String title){
		
		return comicRepository.findAllByTitle(title);
		
	}
	
	public void remove(Comic comic){
		comicRepository.delete(comic);
	}

}
