package com.codingdojo.student_roster.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.student_roster.models.Contact;

public interface ContactRepository extends CrudRepository <Contact,Long> {

}
