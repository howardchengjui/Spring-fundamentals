package com.codingdojo.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Train {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
    public String process(@RequestParam(value="code") String code) {
		if (code.equals("bushido")) {
			return "success.jsp";
		}else {
			return "redirect:/createError";
		}
			
	}
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "You must train harder!");
        return "redirect:/";
	}
}