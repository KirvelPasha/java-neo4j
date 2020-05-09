package com.demo.controller;

import com.demo.dto.FacultyDto;
import com.demo.interfaces.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<FacultyDto> get() {
        return new ResponseEntity<>(facultyService.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Validated @RequestBody FacultyDto facultyDto) {
        facultyService.save(facultyDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}