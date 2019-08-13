package com.codingdojo.springboot;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class HelloHuman {
	@RequestMapping("")
    public String home(Model model) {
		model.addAttribute("dojoName","Berkeley");
		model.addAttribute("dojoName","San Jose");

        return "index.jsp";
    }

	@RequestMapping("/your_server")
    public String success(HttpSession session) {
		if (session.getAttribute("count")==null){
			session.setAttribute("count", 0);
		}else {
			Integer counter= (Integer) session.getAttribute("count");
			counter ++;
			session.setAttribute("count", counter);
		}
        return "index.jsp";
    }
	
	@RequestMapping("/your_server/count")
    public String counter() {
		
        return "success.jsp";
    }
	
	@RequestMapping("/your_server/clear")
    public String clear(HttpSession session) {
			session.setAttribute("count", 0);
			
        return "index.jsp";
    }
}


