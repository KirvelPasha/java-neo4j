package com.demo.impl;

import com.demo.converter.StudentConverter;
import com.demo.dto.StudentDto;
import com.demo.interfaces.StudentService;
import com.demo.node.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter userConverter;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentConverter userConverter) {
        this.studentRepository = studentRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAll()
                .stream()
                .map(userConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(StudentDto studentDto) {
        Student student = userConverter.convertToEntity(studentDto);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> getByFilter(Integer mark) {
        if (mark < 4 || mark > 10) {
            throw new IllegalArgumentException();
        }
        return studentRepository.getByFilter(mark)
                .stream()
                .map(userConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
