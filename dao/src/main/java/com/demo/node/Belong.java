package com.demo.node;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "BELONG_TO")
public class Belong {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Specialty specialty;
    @EndNode
    private Faculty faculty;
    private String dateOfFoundation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(String dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    @Override
    public String toString() {
        return "Belong{" +
                "id=" + id +
                ", specialty=" + specialty +
                ", faculty=" + faculty +
                ", dateOfFoundation='" + dateOfFoundation + '\'' +
                '}';
    }
}