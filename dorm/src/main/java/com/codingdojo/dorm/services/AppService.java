package com.codingdojo.dorm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dorm.models.Course;
import com.codingdojo.dorm.models.Dorm;
import com.codingdojo.dorm.models.Student;
import com.codingdojo.dorm.models.StudentCourse;
import com.codingdojo.dorm.repositories.ClassRepository;
import com.codingdojo.dorm.repositories.DormRepository;
import com.codingdojo.dorm.repositories.StudentCourseRepository;
import com.codingdojo.dorm.repositories.StudentRepository;

@Service
public class AppService {
	@Autowired
	private DormRepository dormRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private ClassRepository classRepo;
	@Autowired
	private StudentCourseRepository studentCourseRepo;
	public void createDorm(@Valid Dorm dorm) {
		// TODO Auto-generated method stub
		dormRepo.save(dorm);
	}

	public void createStudent(@Valid Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
	}

	public List<Dorm> getAllDorms() {
		// TODO Auto-generated method stub
		return dormRepo.findAll();
	}

	public Dorm getDorm(Long id) {
		// TODO Auto-generated method stub
		Optional<Dorm> optDorm = dormRepo.findById(id);
		if(optDorm.isPresent()) {
			return optDorm.get();
		}else {
			return null;
		}
	}

	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> optStudent = studentRepo.findById(id);
		if(optStudent.isPresent()) {
			return optStudent.get();
		}else {
			return null;
		}
	}

	public Course createCourse(@Valid Course course) {
		// TODO Auto-generated method stub
		return classRepo.save(course);
	}

	public Course findOneClass(Long id) {
		// TODO Auto-generated method stub
		Optional<Course> optClass=classRepo.findById(id);
		if(optClass.isPresent()) {
			return optClass.get();
		}else {
			return null;
		}
	}


	public StudentCourse createStudentCourse(@Valid StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		return studentCourseRepo.save(studentCourse);
	}

	public List<Course> getAllCoursesNotInStudents(Student student) {
		// TODO Auto-generated method stub
		List<String> ListInStudent = new ArrayList<String>();
		if(student.getCourse().size()==0) {
			ListInStudent.add("");
		}
		for(Course c : student.getCourse()) {
			ListInStudent.add(c.getName());
		}
		
		return classRepo.findByNameNotIn(ListInStudent);
	}


	
	
}
