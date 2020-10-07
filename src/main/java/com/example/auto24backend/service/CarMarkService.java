package com.example.auto24backend.service;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.repository.CarMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarMarkService {

    @Autowired
    private CarMarkRepository carMarkRepository;

    public List<CarMark> findAll() {
        return carMarkRepository.findAll();
    }
}
