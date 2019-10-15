package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	@Autowired
	LookifyRepository lookifyRepo;
	public List<Song> getAllSongs() {
		// TODO Auto-generated method stub
		
		return lookifyRepo.findAll();
	}
	public Song getThisSong(Long id) {
		// TODO Auto-generated method stub
		Optional <Song> optionalSong = lookifyRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}else{
			return null;
		}
	}
	public void deleteThisSong(Long id) {
		// TODO Auto-generated method stub
		lookifyRepo.deleteById(id);
	}
	public void createNewSong(@Valid Song newSong) {
		// TODO Auto-generated method stub
		lookifyRepo.save(newSong);
	}
	public List <Song> searchsong(String artist) {
		// TODO Auto-generated method stub
		return lookifyRepo.findByArtistContaining(artist);
	}
	public List<Song> searchtop() {
		// TODO Auto-generated method stub
		return lookifyRepo.findTop10ByOrderByRatingDesc();
	}
	
}
