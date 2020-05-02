package com.demo.dto;

import javax.validation.constraints.NotBlank;

public class SpecialtyDto {
    @NotBlank
    private String name;
    @NotBlank
    private String dateOfFoundation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(String dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }
}
