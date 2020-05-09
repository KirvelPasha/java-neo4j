package com.demo.impl;

import com.demo.converter.FacultyConverter;
import com.demo.dto.FacultyDto;
import com.demo.interfaces.FacultyService;
import com.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public FacultyDto get() {
        return facultyConverter.convertToDto(facultyRepository.get());
    }

    @Override
    public void save(FacultyDto facultyDto) {
        facultyRepository.customSave(facultyDto.getDescription());
    }
}