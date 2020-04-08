package com.demo.repository;

import com.demo.node.Student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long> {
    @Query("MATCH (s:Student) Return s")
    List<Student> getAll();

    @Query("MATCH (s:Student)-[r:STUDY_AT]->(f:Faculty) WHERE s.mark > {mark} RETURN s, r, f")
    List<Student> getByFilter(@Param("mark") Integer mark);
}