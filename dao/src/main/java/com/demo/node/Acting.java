package com.demo.node;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "STUDY_AT")
public class Acting {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Student student;
    @EndNode
    private Specialty specialty;
    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent() {
        return student.getLogin();
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSpecialty() {
        return specialty.getName();
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Acting{" +
                "id=" + id +
                ", student=" + getStudent() +
                ", specialty=" + getSpecialty() +
                ", rating=" + rating +
                '}';
    }
}
