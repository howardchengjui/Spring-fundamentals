package com.codingdojo.tvshow.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.tvshow.models.Show;
import com.codingdojo.tvshow.repositories.ShowRepository;

@Service
public class ShowService {
	@Autowired
	ShowRepository showRepo;
	
	public List<Show> findAllShows() {
		// TODO Auto-generated method stub
		return showRepo.findAll();
	}
	public void createShow(@Valid Show newshow) {
		// TODO Auto-generated method stub
		showRepo.save(newshow);
	}
	public Show findShow(Long id) {
		// TODO Auto-generated method stub
		Optional<Show>optShow=showRepo.findById(id);
		if(optShow.isPresent()) {
			return optShow.get();
		}else {
			return null;
		}
		
	}
	public void update(Show newshow) {
		// TODO Auto-generated method stub
		showRepo.save(newshow);

	}
	public void deleteShow(Long id) {
		// TODO Auto-generated method stub
		 showRepo.deleteById(id);
	}

}
