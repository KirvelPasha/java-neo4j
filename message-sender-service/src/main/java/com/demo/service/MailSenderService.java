package com.demo.service;


import com.demo.dto.StudentDto;
import com.demo.model.SentMail;
import com.demo.repository.SentMailRepository;
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

    public void sendMailWithStudentInfo(String emailTo, List<StudentDto> studentDtoList) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailTo);
        simpleMailMessage.setSubject(subject);
        this.createMessage(studentDtoList, simpleMailMessage);
        this.saveSentMail(emailTo, studentDtoList);

        javaMailSender.send(simpleMailMessage);
    }

    public void sendMailWithoutStudentInfo(String emailTo) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailTo);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("Sorry");
        javaMailSender.send(simpleMailMessage);
    }

    public void resetMail(String correctMail, String wrongMail) {
        Optional<SentMail> sentMailOptional = sentMailRepository.findById(wrongMail);
        sentMailOptional.ifPresent(sentMail -> this.sendMailWithStudentInfo(correctMail, sentMail.getStudentDtoList()));
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
