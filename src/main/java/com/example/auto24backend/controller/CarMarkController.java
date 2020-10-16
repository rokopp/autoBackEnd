package com.example.auto24backend.controller;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.service.CarMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarMarkController {

    @Autowired
    private CarMarkService carMarkService;

    @GetMapping("/api/carMarks")
    public List<CarMark> carMarksList() {
        return carMarkService.findAll();
    }

    @PostMapping("/api/carMarks")
    public CarMark saveCarMark(@RequestBody CarMark carMark) {
        return carMarkService.save(carMark);
    }
}
