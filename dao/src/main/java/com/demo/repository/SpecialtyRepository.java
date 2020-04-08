package com.demo.repository;

import com.demo.node.Specialty;
import com.demo.node.Student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends Neo4jRepository<Specialty, Long> {
    @Query("MATCH p=()-[r:STUDY_AT]->() RETURN p")
    List<Specialty> getAll();
}
