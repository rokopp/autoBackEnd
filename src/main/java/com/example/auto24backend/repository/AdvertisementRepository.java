package com.example.auto24backend.repository;

import com.example.auto24backend.database.Advertisement;
import com.example.auto24backend.database.CarMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAllByCarMark(CarMark carMark);

    List<Advertisement> findAllByPriceBetween(Integer price, Integer price2);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Advertisement a WHERE a.id=?1")
    void delete(Long entityId);
}
