package com.example.auto24backend.service;

import com.example.auto24backend.database.Marks;
import com.example.auto24backend.database.MarksRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarMarksService {

    @Autowired
    private MarksRepository marksRepository;

    public String findAll() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Marks> marks = marksRepository.findAllByOrderByCarMark();

            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(marks);

        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }


}
