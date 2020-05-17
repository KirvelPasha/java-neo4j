package com.demo.controller;

import com.demo.dto.StudentDto;
import com.demo.interfaces.StudentService;
import com.demo.wrapper.StudentDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return new ResponseEntity<>(studentService.getAllTest(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/filter")
    public ResponseEntity<StudentDtoList> getByFilter(@RequestParam Integer mark) {
        StudentDtoList studentDtoList = new StudentDtoList(studentService.getByFilter(mark));
        return new ResponseEntity<>(studentDtoList, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestParam String name, @RequestParam String surname) {
        studentService.delete(name, surname);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
