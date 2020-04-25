package com.demo.repository;

import com.demo.node.Faculty;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends Neo4jRepository<Faculty, Long> {
    @Query("MATCH (f:Faculty)<-[r:BELONG_TO]-(s:Specialty) RETURN f, r, s")
    Faculty get();
}