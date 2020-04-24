package com.demo.wrapper;

import com.demo.dto.StudentDto;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "student")
public class StudentDtoList {
    private List<StudentDto> studentDtoList;

    public StudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }

    public StudentDtoList() {
    }

    public List<StudentDto> getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }
}
