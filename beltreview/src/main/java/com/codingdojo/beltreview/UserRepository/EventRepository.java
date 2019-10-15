package com.codingdojo.beltreview.UserRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreview.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
 List<Event> findByStateEquals(String state);
 
 List<Event> findByStateNot(String state);

}
