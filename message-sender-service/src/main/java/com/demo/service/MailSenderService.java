package com.demo.service;


import com.demo.dto.StudentDto;
import com.demo.model.SentMail;
import com.demo.repository.SentMailRepository;
import com.demo.utility.HelperImpl;
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
    private final HelperImpl helper;

    @Autowired
    public MailSenderService(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender,
                             SentMailRepository sentMailRepository, HelperImpl helper) {
        this.javaMailSender = javaMailSender;
        this.sentMailRepository = sentMailRepository;
        this.helper = helper;
    }

    public void sendMailWithStudentInfo(String emailTo, List<StudentDto> studentDtoList) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailTo);
        simpleMailMessage.setSubject(subject);
        helper.createMessage(studentDtoList, simpleMailMessage);
//        this.saveSentMail(emailTo, studentDtoList);

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
        Optional<SentMail> sentMailOptional = sentMailRepository.findByMail(wrongMail);
        if (sentMailOptional.isPresent()) {
            SentMail sentMailWithCorrectMail = sentMailOptional.get();
            sentMailWithCorrectMail.setMail(correctMail);
            sentMailRepository.save(sentMailWithCorrectMail);
            this.sendMailWithStudentInfo(correctMail, sentMailWithCorrectMail.getStudentDtoList());
        }
    }

    private void saveSentMail(String emailTo, List<StudentDto> studentDtoList) {
        SentMail sentMail = new SentMail(emailTo, studentDtoList);
        sentMailRepository.save(sentMail);
    }
}
