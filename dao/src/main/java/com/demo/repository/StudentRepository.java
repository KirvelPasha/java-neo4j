package com.demo.repository;

import com.demo.node.Student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long> {
    @Query("MATCH (s:Student) Return s")
    List<Student> getAll();

    @Query("MATCH (s:Student)-[r:STUDY_AT]->(f:Faculty) WHERE s.mark >= $mark RETURN s, r, f")
    List<Student> getByFilter(@Param("mark") Integer mark);

    @Query("MATCH (s:Student)-[r:STUDY_AT]->(f:Specialty) RETURN s, r, f")
    List<Student> getAllTest();

    @Query("CREATE (a:Student{name: $name, surname: $surname, mark: $mark, mail: $mail})")
    void customSave(@Param("name") String name, @Param("surname") String surname, @Param("mark") Integer mark,
                    @Param("mail") String mail);

    @Query("MATCH (a:Student),(b:Specialty) WHERE a.name = $name AND b.name = $specialtyName \n" +
            " CREATE (a)-[r:STUDY_AT]->(b)")
    void saveWithRelationship(@Param("name") String name, @Param("specialtyName") String specialtyName);

    @Query("MATCH (n { name: $name, surname: $surname }) DETACH DELETE n")
    void delete(@Param("name") String name, @Param("surname")String surname);

    @Query("MATCH (s:Student)-[r:STUDY_AT]->(f:Faculty) WHERE s.name = $name AND s.surname = $surname s, r, f")
    Optional<Student> getByFilter(@Param("name") String name, @Param("surname") String surname);
}