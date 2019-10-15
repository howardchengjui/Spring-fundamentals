package com.codingdojo.student_roster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.student_roster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student,Long> {
	
	
}
