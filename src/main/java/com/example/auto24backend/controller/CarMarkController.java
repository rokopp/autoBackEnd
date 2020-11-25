package com.example.auto24backend.controller;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.service.CarMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/carMarks")
@RestController
public class CarMarkController {

    @Autowired
    private CarMarkService carMarkService;

    @GetMapping
    public List<CarMark> carMarksList() {
        return carMarkService.findAll();
    }

    @PostMapping
    public CarMark saveCarMark(@RequestBody CarMark carMark) {
        return carMarkService.save(carMark);
    }
}
