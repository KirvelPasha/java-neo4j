package com.demo.repository;

import com.demo.node.Specialty;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends Neo4jRepository<Specialty, Long> {
}
