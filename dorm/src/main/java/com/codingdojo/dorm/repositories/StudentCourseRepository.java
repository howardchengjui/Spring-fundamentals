package com.codingdojo.dorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dorm.models.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository <StudentCourse,Long> {

}
