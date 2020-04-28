package com.demo.impl;

import com.demo.converter.SpecialtyConverter;
import com.demo.dto.SpecialtyDto;
import com.demo.interfaces.SpecialtyService;
import com.demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyConverter specialtyConverter;

    @Autowired
    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository, SpecialtyConverter specialtyConverter) {
        this.specialtyRepository = specialtyRepository;
        this.specialtyConverter = specialtyConverter;
    }

    @Override
    public List<SpecialtyDto> getAll() {
        System.out.println(specialtyRepository.get());
        return specialtyRepository.getAll()
                .stream()
                .map(specialtyConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(SpecialtyDto specialtyDto) {
        specialtyRepository.customSave(specialtyDto.getName());
        specialtyRepository.saveWithRelationship(specialtyDto.getName());
    }
}
