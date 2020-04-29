package com.demo.controller;


import com.demo.service.MailSenderService;
import com.demo.utility.CheckHelper;
import com.demo.wrapper.StudentDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/mails")
public class MailSenderController {
    private final RestTemplate restTemplate;
    private final MailSenderService mailSenderService;
    private final CheckHelper checkHelper;

    @Autowired
    public MailSenderController(RestTemplate restTemplate, MailSenderService mailSenderService, CheckHelper checkHelper) {
        this.restTemplate = restTemplate;
        this.mailSenderService = mailSenderService;
        this.checkHelper = checkHelper;
    }

    @GetMapping
    public ResponseEntity<Void> sendMessage(@RequestParam String mail, @RequestParam Integer mark) {
        Optional<StudentDtoList> optionalStudentDtoList = Optional
                .ofNullable(restTemplate.getForObject("http://main-server/students/filter?mark=" + mark, StudentDtoList.class));
        if (optionalStudentDtoList.isPresent() && !checkHelper.isEmptyList(optionalStudentDtoList.get())) {
            mailSenderService.sendMailWithStudentInfo(mail, optionalStudentDtoList.get().getStudentDtoList());
        } else {
            mailSenderService.sendMailWithoutStudentInfo(mail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/reset")
    public ResponseEntity<Void> reset(@RequestParam String correctMail, @RequestParam String wrongMail) {
        mailSenderService.resetMail(correctMail, wrongMail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
