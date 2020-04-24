package com.demo.node;

import org.neo4j.ogm.annotation.*;

import java.util.List;


@NodeEntity(label = "Specialty")
public class Specialty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "STUDY_AT", direction = Relationship.INCOMING)
    private List<Student> studentList;
//    @Relationship(type = "BELONG_TO")
//    private Belong belong;


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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


}