package com.demo.interfaces;

import com.demo.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();

    void save(StudentDto studentDto);

    List<StudentDto> getByFilter(Integer mark);

    List<StudentDto> getAllTest();
}
