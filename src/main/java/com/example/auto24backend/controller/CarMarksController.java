package com.example.auto24backend.controller;

import com.example.auto24backend.service.CarMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarMarksController {

    @Autowired
    private CarMarksService carMarksService;

    @RequestMapping("/api/getCarMarks")
    public String carMarksList() {
        return carMarksService.findAll();
    }
}
