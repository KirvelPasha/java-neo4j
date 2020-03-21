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

    //    @Query("MATCH (u:Student)-[r:STUDY_IN]->(s:Specialty) WHERE r.mark > 12 RETURN u")
    @Query("MATCH (s:Student) WHERE s.mark > {mark} RETURN s")
    List<Student> getByFilter(@Param("mark") Integer mark);
}
