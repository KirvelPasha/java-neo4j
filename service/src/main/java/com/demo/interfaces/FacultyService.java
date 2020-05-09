package com.demo.interfaces;

import com.demo.dto.FacultyDto;

public interface FacultyService {
    FacultyDto get();

    void save(FacultyDto facultyDto);
}
