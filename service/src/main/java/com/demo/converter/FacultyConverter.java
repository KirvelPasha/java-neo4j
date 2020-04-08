package com.demo.converter;

import com.demo.dto.FacultyDto;
import com.demo.node.Faculty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacultyConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public FacultyConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FacultyDto convertToDto(Faculty faculty) {
        return modelMapper.map(faculty, FacultyDto.class);
    }
}
