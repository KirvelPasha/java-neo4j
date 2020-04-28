package com.demo.controller;

import com.demo.dto.SpecialtyDto;
import com.demo.interfaces.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @Autowired
    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyDto>> getAll() {
        return new ResponseEntity<>(specialtyService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SpecialtyDto specialtyDto) {
        specialtyService.save(specialtyDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
 }