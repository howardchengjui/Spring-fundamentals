package com.codingdojo.beltreview.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.beltreview.models.Event;
import com.codingdojo.beltreview.models.User;
import com.codingdojo.beltreview.services.EventService;
import com.codingdojo.beltreview.services.UserService;

@Controller
public class EventController {
	@Autowired 
	UserService userService;
	
	@Autowired 
	EventService eventService;
	
///////////////////////////////////show_events/////////////////////////////
	 @RequestMapping("/events")
	    public String home(@Valid HttpSession session, Model model,@ModelAttribute("newEventObj") Event newevent,BindingResult result) {
	    	User u = (User)session.getAttribute("user");
	    	String state= u.getState();
	    	List<Event> instateevent=eventService.getInStateEvent(state);
	    	List<Event> otherStateEvents=eventService.getAllOtherEvents(state);
	    	model.addAttribute("user", u);
	    	model.addAttribute("instateevents", instateevent);
	    	model.addAttribute("outofstateevents", otherStateEvents);    	
	    	return "authentication/homePage.jsp";
	        // get user from session, save them in the model and return the home page
	    }
//////////////////////////create_new_event////////////////////////////
	@PostMapping("/newevent")
    public String newevent(@Valid @ModelAttribute("newEventObj") Event newevent,BindingResult result,HttpSession session,RedirectAttributes errors) {
		if(result.hasErrors()) {
    		return "authentication/homePage.jsp";
    	}else {
    		eventService.createEvent(newevent);		
    		return "redirect:/events";
    	}
	}	
/////////////////////////show_event///////////////////////////////
	@RequestMapping("/events/{id}")
	public String showevent(@PathVariable("id") Long id,@ModelAttribute("newEventObj") Event newevent, HttpSession session,Model model) {
    	Event e = eventService.findEvent(id);
    	model.addAttribute("newEventObj",e);
    	return "event/showPage.jsp";
	}
/////////////////////////join_event////////////////////////////
	@RequestMapping("/join/{id}")
	public String joinevent(@PathVariable("id")Long id,HttpSession session) {
    	User user = (User)session.getAttribute("user");
    	Event e = eventService.findEvent(id);
    	List<User> going= e.getUsersAttending();
    	going.add(user);
    	e.setUsersAttending(going);
    	userService.update(user);
    	return "redirect:/events";
	}
/////////////////////////leave_event///////////////////////////
	@RequestMapping("/leave/{id}")
	public String leaveevent(@PathVariable("id")Long id,HttpSession session) {
		User user = (User)session.getAttribute("user");
    	Event e = eventService.findEvent(id);
    	List<User> going= e.getUsersAttending();
    	for (int i = 0; i < going.size(); i++) {
			if (going.get(i).getId() == user.getId()) {
				going.remove(i);
			}
		}
		e.setUsersAttending(going);
		userService.update(user);
		return "redirect:/home";
	}
}