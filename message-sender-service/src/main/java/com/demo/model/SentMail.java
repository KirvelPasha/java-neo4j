package com.demo.model;

import com.demo.dto.StudentDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sentmail")
public class SentMail {
    @Id
    private String mail;
    private List<StudentDto> studentDtoList;

    public SentMail(String mail, List<StudentDto> studentDtoList) {
        this.mail = mail;
        this.studentDtoList = studentDtoList;
    }

    public SentMail() {
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
