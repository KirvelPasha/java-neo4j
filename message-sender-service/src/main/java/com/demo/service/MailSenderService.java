package com.demo.service;


import com.demo.dto.StudentDto;
import com.demo.model.SentMail;
import com.demo.repository.SentMailRepository;
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
    private final SentMailRepository sentMailRepository;

    @Autowired
    public MailSenderService(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender,
                             SentMailRepository sentMailRepository) {
        this.javaMailSender = javaMailSender;
        this.sentMailRepository = sentMailRepository;
    }

    public void send(String emailTo, Optional<StudentDtoList> optionalStudentDtoList) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailTo);
        simpleMailMessage.setSubject(subject);
        boolean studentsFind = false;
        if (optionalStudentDtoList.isPresent()) {
            List<StudentDto> studentDtoList = optionalStudentDtoList.get().getStudentDtoList();
            if (!studentDtoList.isEmpty()) {
                this.createMessage(studentDtoList, simpleMailMessage);
                studentsFind = true;

                this.saveSentMail(emailTo, studentDtoList);
            }
        }
        if (!studentsFind) {
            simpleMailMessage.setText("Sorry");
        }
        javaMailSender.send(simpleMailMessage);
    }

    private void createMessage(List<StudentDto> studentDtoList, SimpleMailMessage simpleMailMessage) {
        StringBuilder message = new StringBuilder();
        studentDtoList.forEach(studentDto -> message.append(studentDto.getMail()).append('\n'));
        simpleMailMessage.setText(message.toString());

    }

    private void saveSentMail(String emailTo, List<StudentDto> studentDtoList) {
        SentMail sentMail = new SentMail(emailTo, studentDtoList);
        sentMailRepository.save(sentMail);
    }
}
