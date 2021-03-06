package com.demo.repository;

import com.demo.node.Faculty;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends Neo4jRepository<Faculty, Long> {
    @Query("MATCH (s:Specialty)-[r:BELONG_TO]->(f:Faculty) RETURN f, r, s")
    Faculty get();

    @Query("CREATE (a:Faculty{name: 'MMF', description: $description})")
    void customSave(@Param("description") String description);

}