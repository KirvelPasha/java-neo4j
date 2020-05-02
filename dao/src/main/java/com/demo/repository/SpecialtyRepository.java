package com.demo.repository;

import com.demo.node.Specialty;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends Neo4jRepository<Specialty, Long> {
    @Query("MATCH p=()-[r:STUDY_AT]->() RETURN p")
    List<Specialty> getAll();

    @Query("MATCH (s:Specialty)-[r:BELONG_TO]->(f:Faculty) RETURN f, r, s")
    List<Specialty> get();

    @Query("CREATE (a:Specialty{name: $name})")
    void customSave(@Param("name") String name);

    @Query("MATCH (a:Specialty),(b:Faculty) WHERE a.name = $name AND b.description = 'MMF' \n" +
            " CREATE (a)-[r:BELONG_TO{dateOfFoundation: $dateOfFoundation}]->(b)")
    void saveWithRelationship(@Param("name") String name, @Param("dateOfFoundation") String dateOfFoundation);
}
