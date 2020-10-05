package com.example.auto24backend.service;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.repository.CarMarkRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarMarkService {

    @Autowired
    private CarMarkRepository carMarkRepository;

    public String findAll() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<CarMark> marks = carMarkRepository.findAllByOrderByCarMark();

            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(marks);

        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

}
