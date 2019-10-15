package com.codingdojo.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltreview.UserRepository.EventRepository;
import com.codingdojo.beltreview.UserRepository.UserRepository;
import com.codingdojo.beltreview.models.Event;

@Service
public class EventService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	EventRepository eventRepository;
	
	public List<Event> getInStateEvent(String state) {
		// TODO Auto-generated method stub
		
		return eventRepository.findByStateEquals(state);
	}

	public List<Event> getAllOtherEvents(String state) {
		// TODO Auto-generated method stub
		return eventRepository.findByStateNot(state);	
		}

	public void createEvent(Event newevent) {
		 eventRepository.save(newevent);		
	}

	public Event findEvent(Long id) {
		// TODO Auto-generated method stub
		Optional<Event>optEvent=eventRepository.findById(id);
		if(optEvent.isPresent()) {
			return optEvent.get();
		}else {
			return null;
		}
	}


}
