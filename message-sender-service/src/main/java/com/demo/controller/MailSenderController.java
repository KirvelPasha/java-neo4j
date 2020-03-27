package com.demo.controller;


import com.demo.service.MailSenderService;
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
@RequestMapping("C")
public class MailSenderController {
    private final RestTemplate restTemplate;
    private final MailSenderService mailSenderService;

    @Autowired
    public MailSenderController(RestTemplate restTemplate, MailSenderService mailSenderService) {
        this.restTemplate = restTemplate;
        this.mailSenderService = mailSenderService;
    }

    @GetMapping("/hello")
    public String sendMessage() {
       return "Hello World";
    }

    @GetMapping
    public ResponseEntity<Void> sendMessage(@RequestParam String mail, @RequestParam Integer mark) {
        Optional<StudentDtoList> optionalStudentDtoList = Optional
                .ofNullable(restTemplate.getForObject("http://main-server/students/filter?mark=" + mark, StudentDtoList.class));
        mailSenderService.send(mail, optionalStudentDtoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
