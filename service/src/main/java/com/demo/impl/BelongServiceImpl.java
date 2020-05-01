package com.demo.impl;

import com.demo.interfaces.BelongService;
import com.demo.repository.BelongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BelongServiceImpl implements BelongService {
    private final BelongRepository belongRepository;

    @Autowired
    public BelongServiceImpl(BelongRepository belongRepository) {
        this.belongRepository = belongRepository;
    }


    @Override
    public Integer getCountSpecialties() {
        return belongRepository.getCountSpecialties();
    }
}
