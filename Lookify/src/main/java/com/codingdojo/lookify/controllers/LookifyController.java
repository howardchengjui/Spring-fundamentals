package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class LookifyController {
	@Autowired
	LookifyService lookifyServ;
///////////////////////////////////welcome//////////////////////////////////
	@GetMapping("/")
	public String dash() {
		return "songs/index.jsp";
	}

///////////////////////////////////dashboard//////////////////////////////////
	@GetMapping("/dashboard")
	public String home(Model model) {
		List<Song> allSongs= lookifyServ.getAllSongs();
		model.addAttribute("allSongs",allSongs);
		return "songs/dash.jsp";
	}
///////////////////////////////////show//////////////////////////////////
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id ,Model model) {
		Song thisSong = lookifyServ.getThisSong(id);
		model.addAttribute("thisSong",thisSong);
		return "songs/show.jsp";
	}
///////////////////////////////////delete//////////////////////////////////
	@DeleteMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		lookifyServ.deleteThisSong(id);
		return "redirect:/dashboard";
	}
///////////////////////////////////new//////////////////////////////////
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("newSong",new Song());
		return "songs/new.jsp";
	}
///////////////////////////////////create//////////////////////////////////
	@PostMapping("/create")
	public String createSong(@Valid @ModelAttribute("newSong") Song newSong, BindingResult results) {
		if(results.hasErrors()) {
			return "songs/new.jsp";
		}else {
			lookifyServ.createNewSong(newSong);
			return "redirect:/dashboard";
	}
}
///////////////////////////////////top//////////////////////////////////
	@GetMapping("/top")
	public String top(Model model) {
		List<Song> topten= lookifyServ.searchtop();
		model.addAttribute("topten",topten);
		return "songs/top.jsp";
	}
///////////////////////////////////search//////////////////////////////////
	@PostMapping("/search")
	public String search(@RequestParam(value="artist") String artist, Model model) {
		List<Song> songsbyaritist= lookifyServ.searchsong(artist);
		model.addAttribute("songs",songsbyaritist);
		return "songs/artist.jsp";
	}
}

