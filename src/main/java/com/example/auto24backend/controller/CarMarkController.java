package com.example.auto24backend.controller;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.exceptions.InvalidCarMarkException;
import com.example.auto24backend.service.CarMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping({"api/carMarks", "/api/admin/carMarks"})
@RestController
public class CarMarkController {

    @Autowired
    private CarMarkService carMarkService;

    @GetMapping
    public List<CarMark> carMarksList() {
        return carMarkService.findAll();
    }

    @PostMapping
    public String saveCarMark(@RequestBody CarMark carMark) {
        try {
            carMarkService.save(carMark);
        } catch (InvalidCarMarkException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "Successfully added";
    }

}
