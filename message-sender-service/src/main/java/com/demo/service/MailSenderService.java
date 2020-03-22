package com.demo.service;

//import com.demo.dto.StudentDto;

import com.demo.dto.StudentDto;
import com.demo.wrapper.StudentDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MailSenderService {
    private final String subject = "MMF";
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSenderService(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void send(String emailTo, Optional<StudentDtoList> optionalStudentDtoList) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailTo);
        simpleMailMessage.setSubject(subject);
        boolean studentsFind = false;
        if (optionalStudentDtoList.isPresent()) {
            List<StudentDto> studentDtoList = optionalStudentDtoList.get().getStudentDtoList();
            if (!studentDtoList.isEmpty()) {
                StringBuilder message = new StringBuilder();
                studentDtoList.forEach(studentDto -> message.append(studentDto.getMail()).append('\n'));
                simpleMailMessage.setText(message.toString());
                studentsFind = true;
            }
        }
        if (!studentsFind) {
            simpleMailMessage.setText("Sorry");
        }
        javaMailSender.send(simpleMailMessage);
    }
}
