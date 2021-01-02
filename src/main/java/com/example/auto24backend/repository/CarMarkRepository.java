package com.example.auto24backend.repository;

import com.example.auto24backend.database.CarMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMarkRepository extends JpaRepository<CarMark, Long> {

    CarMark findByCarMark(String carMark);
}
