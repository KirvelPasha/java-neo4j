package com.demo.converter;

import com.demo.dto.SpecialtyDto;
import com.demo.node.Specialty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public SpecialtyConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SpecialtyDto convertToDto(Specialty specialty) {
        return modelMapper.map(specialty, SpecialtyDto.class);
    }
}