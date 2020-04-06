package com.demo.impl;

import com.demo.converter.FacultyConverter;
import com.demo.dto.FacultyDto;
import com.demo.interfaces.FacultyService;
import com.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyConverter facultyConverter;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, FacultyConverter facultyConverter) {
        this.facultyRepository = facultyRepository;
        this.facultyConverter = facultyConverter;
    }

    @Override
    public List<FacultyDto> getAll() {
        return facultyRepository.getAll()
                .stream()
                .map(facultyConverter::convertToDto)
                .collect(Collectors.toList());
    }
}