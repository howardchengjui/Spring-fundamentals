package com.codingdojo.student_roster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.student_roster.models.Student;
import com.codingdojo.student_roster.services.StudentServices;

@Controller
public class StudentController {
	@Autowired
	StudentServices studentServ;
/////////////////////////////new_student///////////////////////////
	@GetMapping("/student/new")
	public String studentnew(Model model) {
		model.addAttribute("newStudent",new Student());
		return "student_roster/new.jsp";
	}
////////////////////////////create_student//////////////////////////
	@PostMapping("/student/new")
	public String createstudent(@Valid @ModelAttribute("newStudent") Student newStudent, BindingResult results) {
		if (results.hasErrors()) {
			return "student_roster/new.jsp";
		}else {
			studentServ.createStudent(newStudent);
			return "redirect:/student/new";
		}
	}
/////////////////////////////new_student///////////////////////////

}
