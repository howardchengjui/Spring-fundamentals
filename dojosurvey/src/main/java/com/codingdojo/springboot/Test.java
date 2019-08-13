package com.codingdojo.springboot;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
    public String login(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language , @RequestParam(value="comment") String comment) {
			session.setAttribute("name", name);
			session.setAttribute("location", location);
			session.setAttribute("language", language);
			session.setAttribute("comment", comment);
          return "redirect:/success";
    }
	
	@RequestMapping("/success")
    public String success() {

		return "success.jsp";
    }
}
