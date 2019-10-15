package com.codingdojo.dorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dorm.models.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student,Long>{


}
