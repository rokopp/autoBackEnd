package com.example.auto24backend.service;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.exceptions.InvalidAdvertisementException;
import com.example.auto24backend.exceptions.InvalidCarMarkException;
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

    public CarMark save(CarMark carMark) {
        if (carMark.getId() != null) {
            throw new InvalidCarMarkException("Wrong id.");
        } else if (carMark.getCarMark() == null) {
            throw new InvalidCarMarkException("Wrong car mark");
        } else if ( carMarkRepository.findByCarMark(carMark.getCarMark()) != null) {
            throw new InvalidCarMarkException("Car mark already present");
        }
        return carMarkRepository.save(carMark);
    }
}
