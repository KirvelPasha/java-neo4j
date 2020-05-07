package com.demo.repository;

import com.demo.node.Belong;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BelongRepository extends Neo4jRepository<Belong, Long> {
    @Query("MATCH p=()-[r:BELONG_TO]->() RETURN count(p)")
    Integer getCountSpecialties();
}
