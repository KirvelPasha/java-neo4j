package com.demo.controller;


import com.demo.dto.People;
import com.demo.dto.StudentDto;
import com.demo.repository.PeopleRepository;
import com.demo.repository.StudentRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mails")
public class MailSenderController {
    private final RestTemplate restTemplate;
    private final MailSenderService mailSenderService;
    private final PeopleRepository peopleRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public MailSenderController(RestTemplate restTemplate, MailSenderService mailSenderService, PeopleRepository peopleRepository, StudentRepository studentRepository) {
        this.restTemplate = restTemplate;
        this.mailSenderService = mailSenderService;
        this.peopleRepository = peopleRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<Void> sendMessage(@RequestParam String mail, @RequestParam Integer mark) {
        Optional<StudentDtoList> optionalStudentDtoList = Optional
                .ofNullable(restTemplate.getForObject("http://main-server/students/filter?mark=" + mark, StudentDtoList.class));
        mailSenderService.send(mail, optionalStudentDtoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<People> test() {
//        System.out.println(peopleRepository.findAll());

        StudentDtoList studentDtoList = new StudentDtoList();
        studentDtoList.setMail("test1@gmail.com");

        List<StudentDto> test = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        studentDto.setLogin("test1");
        test.add(studentDto);

        studentDtoList.setStudentDtoList(test);
        studentRepository.save(studentDtoList);

        return new ResponseEntity<>(peopleRepository.findByFirstName("Nic"),HttpStatus.OK);
    }

}
