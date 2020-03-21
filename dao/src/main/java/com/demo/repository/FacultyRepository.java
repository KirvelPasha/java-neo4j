package com.demo.repository;

import com.demo.node.Faculty;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends Neo4jRepository<Faculty, Long> {
}
