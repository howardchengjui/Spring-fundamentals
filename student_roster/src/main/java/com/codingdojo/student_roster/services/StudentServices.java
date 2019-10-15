package com.codingdojo.student_roster.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.student_roster.models.Student;
import com.codingdojo.student_roster.repositories.ContactRepository;
import com.codingdojo.student_roster.repositories.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	StudentRepository StudentRepo;
	ContactRepository ContactRepo;
	public void createStudent(@Valid Student newStudent) {
		// TODO Auto-generated method stub
		StudentRepo.save(newStudent);
	}
}
