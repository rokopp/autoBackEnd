package com.example.auto24backend.repository;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.CarMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAllByCarMark(CarMark carMark);

    List<Advertisement> findAllByPriceBetween(Integer price, Integer price2);
}
