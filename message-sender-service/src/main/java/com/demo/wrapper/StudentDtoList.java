package com.demo.wrapper;

import com.demo.dto.StudentDto;

import java.util.List;


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
