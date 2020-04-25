package com.demo.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;


@NodeEntity(label = "Specialty")
public class Specialty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "STUDY_AT", direction = Relationship.INCOMING)
    private Set<Student> studentList;
    @Relationship(type = "BELONG_TO")
    private Belong belong;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    public Belong getBelong() {
        return belong;
    }

    public void setBelong(Belong belong) {
        this.belong = belong;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                ", belong=" + belong +
                '}';
    }
}