package com.demo.repository;

import com.demo.node.Faculty;
import com.demo.node.Student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends Neo4jRepository<Faculty, Long> {
    @Query("MATCH (f:Faculty) Return f")
    List<Faculty> getAll();

    @Query("MATCH (s:Specialty)-[r:BELONG_TO]->(f:Faculty) RETURN s, r, f")
    List<Faculty> getAllTest();
}