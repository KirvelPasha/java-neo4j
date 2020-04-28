package com.demo.repository;

import com.demo.wrapper.StudentDtoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentDtoList, String> {
}
