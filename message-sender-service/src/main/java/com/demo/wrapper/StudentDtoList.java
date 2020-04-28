package com.demo.wrapper;

import com.demo.dto.StudentDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "student")
public class StudentDtoList {
    @Id
    private String mail;
    private List<StudentDto> studentDtoList;

    public StudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }

    public StudentDtoList() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<StudentDto> getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }
}
