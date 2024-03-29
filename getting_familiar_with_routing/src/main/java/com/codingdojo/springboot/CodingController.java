package com.codingdojo.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/coding")
@RestController
public class CodingController {
	@GetMapping("")
	public String index() {
		return "Hello Coding Dojo!";
	}
	@GetMapping("/python")
	public String python() {
		return "Python/Django was awesome";
	}
	@GetMapping("/java")
	public String java() {
		return "Java/Spring is better!";
	}
}
