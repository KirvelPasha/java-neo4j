package com.demo.controller;

import com.demo.interfaces.BelongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/belong")
public class BelongController {
    private final BelongService belongService;

    @Autowired
    public BelongController(BelongService belongService) {
        this.belongService = belongService;
    }

    @GetMapping
    public ResponseEntity<Integer> get() {
        return new ResponseEntity<>(belongService.getCountSpecialties(), HttpStatus.OK);
    }
}
