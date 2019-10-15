package com.codingdojo.dorm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dorm.models.Course;

@Repository
public interface ClassRepository extends CrudRepository<Course,Long>{
	List<Course> findAll();
	List<Course>findByNameNotIn(List<String> listOfCourses);
}
