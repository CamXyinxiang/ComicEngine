package com.comic.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.comic.entity.Comic;
import com.comic.service.ComicService;


@Controller
@RequestMapping("/comic")
public class ComicController {

	@Autowired
	private ComicService comicService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addComic(Model model) {
		Comic comic = new Comic();
		model.addAttribute("comic", comic);
		return "addComic";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addComicPost(@ModelAttribute("comic") Comic comic, HttpServletRequest request) {
		comicService.save(comic);

		MultipartFile comicImage = comic.getComicImage();

		try {
			byte[] bytes = comicImage.getBytes();
			String name = comic.getId() + ".jpg";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/comic/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:comicList";
	}
	
	@RequestMapping("/comicInfo")
	public String comicInfo(@RequestParam("id") Long id, Model model) {
		Comic comic = comicService.findOne(id);
		model.addAttribute("comic", comic);
		
		return "comicInfo";
	}
	
	@RequestMapping("/update")
	public String updateComic(@RequestParam("id") Long id, Model model) {
		Comic comic = comicService.findOne(id);
		model.addAttribute("comic", comic);
		
		return "updateComic";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateComicPost(@ModelAttribute("comic") Comic comic, HttpServletRequest request) {
		comicService.save(comic);
		
		MultipartFile comicImage = comic.getComicImage();
		
		if(!comicImage.isEmpty()) {
			try {
				byte[] bytes = comicImage.getBytes();
				String name = comic.getId() + ".jpg";
				
				Files.delete(Paths.get("src/main/resources/static/image/comic/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/comic/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/comic/comicInfo?id="+comic.getId();
	}
	
	@RequestMapping("/comicList")
	public String comicList(Model model) {
		List<Comic> comicList = comicService.findAll();
		model.addAttribute("comicList", comicList);		
		return "comicList";
		
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("id") Long id, Model model) {
		Comic comic = comicService.findOne(id);
		comicService.remove(comic);
		return "comicList";
	}

}
