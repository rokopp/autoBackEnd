package com.example.auto24backend.controller;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.service.CarMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarMarkController {

    @Autowired
    private CarMarkService carMarkService;

    @RequestMapping("/api/carMarks")
    public List<CarMark> carMarksList() {
        return carMarkService.findAll();
    }
}
