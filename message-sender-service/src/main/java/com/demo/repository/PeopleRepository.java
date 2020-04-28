package com.demo.repository;

import com.demo.dto.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends MongoRepository<People, String> {
     People findByFirstName(String firstName);
}
