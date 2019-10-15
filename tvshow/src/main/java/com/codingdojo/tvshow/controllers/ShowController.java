package com.codingdojo.tvshow.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.tvshow.models.Show;
import com.codingdojo.tvshow.models.User;
import com.codingdojo.tvshow.services.ShowService;
import com.codingdojo.tvshow.services.UserService;

@Controller
public class ShowController {
	@Autowired 
	ShowService showServ;
	@Autowired
	UserService userServ;
////////////////////////////////////show_all//////////////////////
	@RequestMapping("/shows")
	    public String home(@Valid HttpSession session, Model model,@ModelAttribute("newShowObj") Show newshow,BindingResult result) {
		    User u = (User)session.getAttribute("user");
		    List<Show> allshows = showServ.findAllShows();
	    	model.addAttribute("user", u);
	    	model.addAttribute("allshows", allshows);
	    	return "tvshow/homePage.jsp";
	}
//////////////////////////////new_show////////////////////
	@RequestMapping("/newshow")
		public String newshow(Model model,@ModelAttribute("newShowObj")Show newshow,HttpSession session) {
		    User u = (User)session.getAttribute("user");
			model.addAttribute("user", u);
			return "tvshow/new.jsp";
	}
///////////////////////////////add_show//////////////////
	@PostMapping("/newshow")
		public String addshow(Model model,@Valid @ModelAttribute("newShowObj") Show newshow,BindingResult result,HttpSession session,RedirectAttributes errors) {
			if(result.hasErrors()) {
					return "tvshow/new.jsp";
		}else {
			User u = (User)session.getAttribute("user");
			model.addAttribute("user", u);
			showServ.createShow(newshow);
			return "redirect:/shows";
	}
	}
/////////////////////////showpage//////////////////////
		@RequestMapping("/show/{id}")
		public String show(@PathVariable("id") Long id,@ModelAttribute("newShowObj") Show newshow, HttpSession session,Model model) {
			User u = (User)session.getAttribute("user");
			model.addAttribute("user", u);
			Show s = showServ.findShow(id);
	    	
	    	model.addAttribute("newShowObj",s);
	    	
	    	return "tvshow/showPage.jsp";
		}
/////////////////////////rate/////////////////////////
		@PostMapping("/rate/{id}")
		public String rate(@PathVariable("id") Long id,Model model,@Valid @ModelAttribute("newShowObj")Show newshow,@ModelAttribute("user")User user, BindingResult result, HttpSession session) {
//			Show s = showServ.findShow(id);
//			model.addAttribute("newShowObj", s);
//	    	User u = (User)session.getAttribute("user");
//			model.addAttribute("user", u);
//	    	List<User> rated = s.getUsersRated();
//	    	rated.add(user);
//	    	s.setUsersRated(rated);
//	    	userServ.update(user);
			
	    	if(result.hasErrors()) {
	    		return "tvshow/showPage.jsp";
	    	}else {
	    		User u = (User)session.getAttribute("user");
	    		model.addAttribute("user", u);
	    		Show s = showServ.findShow(id);
	    		model.addAttribute("newShowObj",s);
	    		showServ.update(newshow);
		    	return "redirect:/shows";
	    	}
	    	
		}
/////////////////////edit////////////////////////
		@RequestMapping("/edit/{id}")
		public String edit(@PathVariable("id") Long id,@Valid @ModelAttribute("newShowObj") Show newshow, HttpSession session,Model model) {
			User u = (User)session.getAttribute("user");
			model.addAttribute("user", u);
			Show s = showServ.findShow(id);
	    	model.addAttribute("newShowObj",s);
	    	return "tvshow/edit.jsp";
		}
///////////////////////update////////////////////////
		@PostMapping("/edit/{id}")
		public String update(Model model,@PathVariable("id") Long id,@Valid @ModelAttribute("newShowObj") Show newshow, HttpSession session, BindingResult result) {
			User u = (User)session.getAttribute("user");
			model.addAttribute("user", u);
			Show s = showServ.findShow(id);
	    	model.addAttribute("newShowObj",s);
	    	if(result.hasErrors()) {
	    		return "tvshow/edit.jsp";
	    	}else {
	    		showServ.update(newshow);
		    	return "redirect:/show/{id}";
	    	}
		}
//////////////////////DELETE///////////////////////
		@DeleteMapping("delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			showServ.deleteShow(id);
			return "redirect:/shows";
		}
}

