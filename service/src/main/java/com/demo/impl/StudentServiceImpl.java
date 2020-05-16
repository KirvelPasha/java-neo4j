package com.demo.impl;

import com.demo.converter.StudentConverter;
import com.demo.dto.StudentDto;
import com.demo.interfaces.StudentService;
import com.demo.node.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentConverter userConverter,
                              PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
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
//        passwordEncoder.encode("test");
        studentRepository.customSave(studentDto.getName(), studentDto.getSurname(),
                studentDto.getMark(), studentDto.getMail());
        studentRepository.saveWithRelationship(studentDto.getName(), studentDto.getSpecialtyName());
    }


    @Override
    public List<StudentDto> getByFilter(Integer mark) {
        if (mark < 4 || mark > 10) {
            throw new IllegalArgumentException("Mark should be more than 4 but less than 10");
        }

        return studentRepository.getByFilter(mark)
                .stream()
                .map(userConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getAllTest() {
        return studentRepository.getAllTest()
                .stream()
                .map(userConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String name, String surname) {
        if (!getByFilter(name, surname).isPresent()) {
            throw new IllegalArgumentException("Student Not Found");
        }
        studentRepository.delete(name, surname);
    }

    @Override
    public Optional<Student> getByFilter(String name, String surname) {
        return studentRepository.getByFilter(name, surname);
    }
}
