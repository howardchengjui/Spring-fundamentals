package com.codingdojo.dorm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dorm.models.Course;
import com.codingdojo.dorm.models.Dorm;
import com.codingdojo.dorm.models.Student;
import com.codingdojo.dorm.models.StudentCourse;
import com.codingdojo.dorm.services.AppService;

@Controller
public class DormController {
	@Autowired
	AppService appServ;
/////////////////////////////new_dorm////////////////////////////////
	@GetMapping("/dorm/new")
	public String dormnew(@ModelAttribute("newDormObj") Dorm dorm) {
		return "dorm/new.jsp";
	}
/////////////////////////////create_dorm//////////////////////////////
	@PostMapping("/dorm/new")
	public String createdorm(@Valid @ModelAttribute("newDormObj") Dorm dorm ,BindingResult result) {
		if (result.hasErrors()) {
			return "dorm/new.jsp";
		}else {
			appServ.createDorm(dorm);
			return "redirect:/student/new";
		}
	}
//////////////////////////////new_student//////////////////////////////
	@GetMapping("/student/new")
	public String newstudent(Model model,@ModelAttribute("newStudentObj") Student student) {
		List<Dorm> Dorms=appServ.getAllDorms();
		model.addAttribute("Dorms",Dorms);
		return "student/new.jsp";
	}
//////////////////////////////create_student//////////////////////////////
	@PostMapping("/student/new")
	public String createstudent(@Valid @ModelAttribute("newStudentObj") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "student/new.jsp";
		}else {
			appServ.createStudent(student);
			return "redirect:/dorm/"+student.getDorm().getId();
		}
	}
//////////////////////////////show_dorm//////////////////////////////
	@GetMapping("/dorm/{id}")
	public String show(Model model,@PathVariable("id") Long id) {
		Dorm dorm=appServ.getDorm(id);
		model.addAttribute("dorm",dorm);
		model.addAttribute("students",dorm.getStudents());
		return "dorm/show.jsp";
	}
//////////////////////////////delete_dorm//////////////////////////////
	@DeleteMapping("/delete/{id}/{dormid}")
	public String deleteStudent(@PathVariable("id") Long id,@PathVariable("dormid") Long dormid) {
		Student student=appServ.getStudent(id);
		student.setDorm(null);
		appServ.createStudent(student);
		return "redirect:/dorm/"+dormid;
	}

/////////////////////////new_class/////////////////////
	@GetMapping("/class/new")
	public String newClass(@ModelAttribute("newCourseObj") Course course) {
		return "class/new.jsp";
	}
/////////////////////////create_class/////////////////////
	@PostMapping("/class/new")
	public String createclass(@Valid @ModelAttribute("newCourseObj") Course course ,BindingResult result) {
		if (result.hasErrors()) {
			return "class/new.jsp";
		}else {
			Course lecture = appServ.createCourse(course);
			return "redirect:/class/"+ lecture.getId();
		}	
	}
/////////////////////////show_class/////////////////////
	@GetMapping("/class/{course_id}")
	public String showClass(Model model, @PathVariable("course_id") Long course_id) {
	Course course= appServ.findOneClass(course_id);
	List<Student> students=course.getStudents();
	System.out.println(students);
	model.addAttribute("students",students);
	model.addAttribute("course",course);
	return "class/show.jsp";
	}
/////////////////////////show_student//////////////////////
	@GetMapping("student/{id}")
	public String getStudent(Model model,@PathVariable("id") Long id,@ModelAttribute("middleTableObj") StudentCourse studentCourse) {
		Student student=appServ.getStudent(id);
		List<Course> allCourses=appServ.getAllCoursesNotInStudents(student);
		model.addAttribute("student",student);
		model.addAttribute("allCourses",allCourses);
		return "student/show.jsp";
	}
///////////////////////add_course///////////////////////////
	@PostMapping("/addcourses")
	public String addCourses(@Valid @ModelAttribute("middleTableObj") StudentCourse studentCourse,BindingResult result) {
		if(result.hasErrors()) {
			return "student/show.jsp";
		}
		StudentCourse sc= appServ.createStudentCourse(studentCourse);
		return "redirect:/student/"+ sc.getStudent().getId();
	}
///////////////////////delete_course///////////////////////////
	@DeleteMapping("/drop/{id}/{classid}")
	public String deleteClass(@PathVariable("id") Long id, @PathVariable("classid") Long class_id) {
		Student student=appServ.getStudent(id);
		Course course=appServ.findOneClass(class_id);
		List<Course> allCourses=student.getCourse();
		allCourses.remove(course);
		student.setCourse(allCourses);
		appServ.createStudent(student);
		return "redirect:/student/"+id;
	}
	
}
