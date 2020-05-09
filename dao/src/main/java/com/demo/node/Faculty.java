package com.demo.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity(label = "Faculty")
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Relationship(type = "BELONG_TO", direction = Relationship.INCOMING)
    private Set<Specialty> specialties;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", specialties=" + specialties +
                '}';
    }
}