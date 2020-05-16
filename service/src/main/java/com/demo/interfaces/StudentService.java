package com.demo.interfaces;

import com.demo.dto.StudentDto;
import com.demo.node.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> getAll();

    void save(StudentDto studentDto);

    List<StudentDto> getByFilter(Integer mark);

    List<StudentDto> getAllTest();

    void delete(String name, String surname);

    Optional<Student> getByFilter(String name, String surname);
}
