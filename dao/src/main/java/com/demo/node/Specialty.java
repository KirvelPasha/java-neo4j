package com.demo.node;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "STUDY_AT")
public class Specialty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int rating;
    @StartNode
    private Student student;
    @EndNode
    private Faculty faculty;

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}