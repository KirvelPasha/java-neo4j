package com.demo.contoller;

import com.demo.service.MailSenderService;
import com.demo.utility.HelperImpl;
import com.demo.wrapper.StudentDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mails")
public class MailSenderController {
    private final RestTemplate restTemplate;
    private final MailSenderService mailSenderService;
    private final HelperImpl helperImpl;

    @Autowired
    public MailSenderController(RestTemplate restTemplate, MailSenderService mailSenderService, HelperImpl helperImpl) {
        this.restTemplate = restTemplate;
        this.mailSenderService = mailSenderService;
        this.helperImpl = helperImpl;
    }

    @GetMapping
    public ResponseEntity<Void> sendMessage(@RequestParam String mail, @RequestParam Integer mark) {
        Optional<StudentDtoList> optionalStudentDtoList = Optional
                .ofNullable(restTemplate.getForObject("http://main-server/students/filter?mark=" + mark, StudentDtoList.class));
        if (optionalStudentDtoList.isPresent() && !helperImpl.isEmptyList(optionalStudentDtoList.get())) {
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