package com.demo.converter;

import com.demo.dto.StudentDto;
import com.demo.node.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public StudentConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentDto convertToDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    public Student convertToEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }
}
