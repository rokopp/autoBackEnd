package com.example.auto24backend.controller;

import com.example.auto24backend.service.CarMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarMarkController {

    @Autowired
    private CarMarkService carMarkService;

    @RequestMapping("/api/getCarMarks")
    public String carMarksList() {
        return carMarkService.findAll();
    }
}
